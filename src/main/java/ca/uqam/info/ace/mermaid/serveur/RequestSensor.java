package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


    @Path("{mermaidId}/sensor/{id}")
    public class RequestSensor {


        //A modifier par les law
//    @GET
//    @Path("status")
//    public Response getstatus(@PathParam("mermaidId") Integer mermaidId,@PathParam("id") Integer id ) {
//        try {
//            boolean etat = MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistScalarSensor().get(id).isStatus();
//            return Response.status(200).entity(etat).build();
//        } catch (Exception e) {
//            return Response.status(404).build();
//        }
//    }
//
//    @PUT
//    @Path("status")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Boolean postMethod(@FormParam("status") Boolean status, @PathParam("mermaidId") Integer mermaidId, @PathParam("id") Integer id) {
//        MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistScalarSensor().get(id).setStatus(status);
//        return status;
//    }



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

    @PUT
    @Path("value")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer postMethod(@FormParam("value") Integer value, @PathParam("mermaidId") Integer mermaidId, @PathParam("id") Integer id) {
        MermaidRegistry.GLOBAL_REGISTRY.fetch(mermaidId).getlistSensor().get(id).setValue(value);
        return value;
    }

}

