package ca.uqam.info.ace.mermaid.serveur;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("{mermaidId}/pump")
public class RequestPump {



    @GET
    @Path("status")
    public Response getstatus(@PathParam("mermaidId") Integer id) {
        try {
            boolean etat = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().isStatus();
            return Response.status(200).entity(etat).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

//    @PUT
//    @Path("status")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Boolean postMethod(@FormParam("status") Boolean status, @PathParam("mermaidId") Integer id) {
//        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().setStatus(status);
//        return status;
//    }



}
