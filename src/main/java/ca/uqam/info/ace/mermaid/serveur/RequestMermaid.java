package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

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

    @GET
    @Path("speed")
    public Response getspeed(@PathParam("mermaidId") Integer id) {
        try {
            Integer output = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getSpeed();
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("speedmax")
    public Response getspeedmax(@PathParam("mermaidId") Integer id) {
        try {
            Integer output = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getSpeedMax();
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("speed")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postSpeed(@FormParam("speed") Integer speed,@PathParam("mermaidId") Integer id) {
        if ( speed >= 0 && speed <= MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getSpeed()) {
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).setSpeed(speed);
        return Response.status(200).entity(speed).build();
    }
        else {
        return Response.status(416).build();
        }
    }

    @GET
    @Path("depth")
    public Response getsdepth(@PathParam("mermaidId") Integer id) {
        try {
            Integer output = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getDepth();
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("depthmax")
    public Response getsdepthmax(@PathParam("mermaidId") Integer id) {
        try {
            Integer output = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getDepthMax();
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("dive")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postDive(@FormParam("depth") Integer depth, @PathParam("mermaidId") Integer id) {
        if ( depth >= 0 && depth <= MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getDepthMax()) {
            MermaidRegistry.GLOBAL_REGISTRY.fetch(id).setDepth(depth);
            return Response.status(200).entity(depth).build();
        }
        else {
            return Response.status(416).build();
        }

    }



}




