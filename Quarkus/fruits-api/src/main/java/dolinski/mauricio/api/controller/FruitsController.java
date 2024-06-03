package dolinski.mauricio.api.controller;

import dolinski.mauricio.api.crud.Fruit;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("fruits")
public class FruitsController {
    
    private final PgPool client;

    public FruitsController(PgPool client) {
        this.client = client;
    }

    @GET
    public Multi<Fruit> get() {
        return Fruit.findAll(client);
    }

    @GET
    @Path("{id}")
    public Uni<Response> getSingle(Long id) {
        return Fruit.findById(client, id)
                .onItem().transform(fruit -> fruit != null ? Response.ok(fruit) : Response.status(Status.NOT_FOUND)) 
                .onItem().transform(ResponseBuilder::build); 
    }
}
