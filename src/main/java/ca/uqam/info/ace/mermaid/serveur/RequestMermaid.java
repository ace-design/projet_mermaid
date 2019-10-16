package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.beans.property.IntegerProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("{mermaidId}")
public class RequestMermaid {


    @GET
    @Path("name")
    public Response getname(@PathParam("mermaidId") Integer id) {
        try {
            String output = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getName().get();
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("name")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String postMethod(@FormParam("name") String name,@PathParam("mermaidId") Integer id) {
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).setName(name);
        return  name;
    }

    @PUT
    @Path("dive")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer postMethod(@FormParam("depth") Integer depth, @PathParam("mermaidId") Integer id) {
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).setDepth(depth);
        return depth;
    }



}




