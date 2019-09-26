package com.projet_t1.ihm;

import javafx.scene.Parent;
import javafx.scene.text.Text;

import static com.projet_t1.mermaid_model.Pump.PUMP_NUMBER;
import static com.projet_t1.mermaid_model.Pump.PUMP_STATUS;


public class Affichage extends Parent {

    public String Etat(Boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

    public Affichage() {

        Text text = new Text("La pompe " + PUMP_NUMBER.get() +" est " + Etat(PUMP_STATUS.get()));
        this.setTranslateX(70);
        this.setTranslateY(100);
        this.getChildren().add(text);
    }


}
