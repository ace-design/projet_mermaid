package ca.uqam.info.ace.mermaid.serveur;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("{mermaidId}/pump")
public class RequestPump {


    public String Etat(boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

    @GET
    @Path("status/{num}/")
    public Response getstatus(@PathParam("mermaidId") Integer id ,@PathParam("num") Integer numero) {
        boolean etat = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().isStatus();
        String output = "la pompe " + numero + " est : " + Etat(etat);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("newstatus/{num}/{state}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setstatus(@PathParam("mermaidId") Integer id ,@PathParam("num") Integer numero, @PathParam("state") Boolean etat) {
        String output = "la pompe " + numero + " est : " + Etat(etat);
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().setNumber(numero);
        MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().setStatus(etat);
        return Response.status(200).entity(output).build();
    }



}
