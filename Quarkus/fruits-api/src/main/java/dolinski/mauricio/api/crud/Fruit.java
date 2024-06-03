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
}
