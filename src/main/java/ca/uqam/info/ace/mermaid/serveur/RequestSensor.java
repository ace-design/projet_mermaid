package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import ca.uqam.info.ace.mermaid.mermaid.laws.LawsFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


    @Path("{mermaidId}/sensor/{id}")
    public class RequestSensor {


    @GET
    @Path("name")
    public Response getname(@PathParam("mermaidId") Integer mermaidId,@PathParam("id") Integer id ) {
        try {
            String name = MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).isName();
            return Response.status(200).entity(name).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("name")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String postMethod(@FormParam("name") String name, @PathParam("mermaidId") Integer mermaidId, @PathParam("id") Integer id) {
        MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).setName(name);
        return name;
    }

    @GET
    @Path("value")
    public Response getvalue(@PathParam("mermaidId") Integer mermaidId,@PathParam("id") Integer id ) {
        try {
            Double value = MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).getValue();
            return Response.status(200).entity(value).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }


    @GET
    @Path("law")
    public Response getlaw(@PathParam("mermaidId") Integer mermaidId,@PathParam("id") Integer id ) {
        try {
            Double value = MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).getValue();
            return Response.status(200).entity(value).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("law")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String postlaw(@FormParam("law") String name, @PathParam("mermaidId") Integer mermaidId, @PathParam("id") Integer id) {
        LawsFactory lawsFactory = new LawsFactory();
        MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).setVariationLaw(lawsFactory.getLaw(name,1.0));
        return name;
    }

}

