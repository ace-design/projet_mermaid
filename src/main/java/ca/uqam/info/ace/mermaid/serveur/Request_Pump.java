package ca.uqam.info.ace.mermaid.serveur;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("pump")
public class Request_Pump {


    public String Etat(boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

    @GET
    @Path("/{num}/{state}")
    public Response getMsg(@PathParam("num") Integer numero, @PathParam("state") Boolean etat) {
        String output = "la pompe " + numero + " est : " + Etat(etat);
        MermaidRegistry.GLOBAL_REGISTRY.fetch("1").getPump().setNumber(numero);
        MermaidRegistry.GLOBAL_REGISTRY.fetch("1").getPump().setStatus(etat);
        return Response.status(200).entity(output).build();
    }

}
