package ca.uqam.info.ace.mermaid.serveur;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class RequestInfo {

    @GET
    public Response getinfo() {
        String output = "Il y a actuellement " + MermaidRegistry.GLOBAL_REGISTRY.size() + " mermaides dans le registre \n ";
        return Response.status(200).entity(output).build();
    }

}
