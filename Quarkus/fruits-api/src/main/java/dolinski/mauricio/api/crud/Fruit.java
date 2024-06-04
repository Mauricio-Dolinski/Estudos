package dolinski.mauricio.api.crud;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

public class Fruit {

    public Long id;
    public String name;

    public Fruit(){

    }

    public Fruit(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Multi<Fruit> findAll(PgPool client) {
        return client.query("SELECT id, name FROM fruits ORDER BY name ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set)) 
                .onItem().transform(Fruit::from); 
    }

    private static Fruit from(Row row) {
        return new Fruit(row.getLong("id"), row.getString("name"));
    }

    public static Uni<Fruit> findById(PgPool client, Long id) {
        return client.preparedQuery("SELECT id, name FROM fruits WHERE id = $1").execute(Tuple.of(id)) 
            .onItem().transform(RowSet::iterator) 
            .onItem().transform(iterator -> iterator.hasNext() ? from(iterator.next()) : null); 
    }

    public Uni<Long> save(PgPool client) {
        return client.preparedQuery("INSERT INTO fruits (name) VALUES ($1) RETURNING id").execute(Tuple.of(name))
                .onItem().transform(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }

    public Uni<Boolean> update(PgPool client) {
        return client.preparedQuery("UPDATE fruits SET name = $1 WHERE id = $2").execute(Tuple.of(name, id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    public static Uni<Boolean> delete(PgPool client, Long id) {
        return client.preparedQuery("DELETE FROM fruits WHERE id = $1").execute(Tuple.of(id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1); 
    }

    // 2 insertions in the same transaction, the transaction is automatically committed on success or rolled back on failure.
    public static Uni<Void> insertTwoFruits(PgPool client, Fruit fruit1, Fruit fruit2) {
        return client.withTransaction(conn -> {
            Uni<RowSet<Row>> insertOne = conn.preparedQuery("INSERT INTO fruits (name) VALUES ($1) RETURNING id")
                    .execute(Tuple.of(fruit1.name));
            Uni<RowSet<Row>> insertTwo = conn.preparedQuery("INSERT INTO fruits (name) VALUES ($1) RETURNING id")
                    .execute(Tuple.of(fruit2.name));
    
            return Uni.combine().all().unis(insertOne, insertTwo)
                    // Ignore the results (the two ids)
                    .discardItems();
        });
    }
    
}
