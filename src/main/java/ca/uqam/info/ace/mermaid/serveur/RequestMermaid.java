package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.beans.property.StringProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("{mermaidId}")
public class RequestMermaid {

    @GET
    @Path("name")
    public Response getname(@PathParam("mermaidId") Integer id) {
        String output = "le mermaid " + id + " a le nom : " + MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getName();
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("newname/{name}")
    public Response setname(@PathParam("mermaidId") Integer id,@PathParam("name") String name ) {
        String output = "le mermaid " + id + " a le nouveau nom : " + name;
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).setName(name);
        return Response.status(201).entity(output).build();
    }

}


