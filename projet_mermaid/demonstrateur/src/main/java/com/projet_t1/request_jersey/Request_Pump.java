package com.projet_t1.request_jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static com.projet_t1.mermaid_model.Pump.PUMP_NUMBER;
import static com.projet_t1.mermaid_model.Pump.PUMP_STATUS;

@Path("pump")
public class Request_Pump {

    Boolean state;
    Integer number;

    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    //Constructeur (par defaut la pompe est éteinte est n'est pas atribuée)
    public Request_Pump() {
        state=false;
        number = 0;
    }
    public String Etat(){
        if (state) {return "Active";}
        else return "Inactive";
    }

    @GET
    @Path("/{num}/{state}")
    public Response getMsg(@PathParam("num") Integer numero, @PathParam("state") Boolean etat) {
        setNumber(numero);
        setState(etat);
        String output = "la pompe " + numero + " est : " + Etat();
        PUMP_STATUS.setValue(etat);
        PUMP_NUMBER.setValue(numero);
        return Response.status(200).entity(output).build();
    }


}
