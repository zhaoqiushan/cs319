package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Container;

@Path("container")
public class ContainerRest {
    @GET
    @Path("{containerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContainerById(@PathParam("containerId") Integer containerId){
        return Response.ok(containerId, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postContainer(String body){
        Gson g = new GsonBuilder().serializeNulls().create();
        Container c = g.fromJson(body, Container.class);
        //todo: need to finish and validate container creation (container id, creatd/updated at time)
        return Response.ok(g.toJson(c), MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("{containerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateContainer(@PathParam("containerId") Integer cid, String body){
        return Response.ok(cid, MediaType.APPLICATION_JSON).build();
    }
}
