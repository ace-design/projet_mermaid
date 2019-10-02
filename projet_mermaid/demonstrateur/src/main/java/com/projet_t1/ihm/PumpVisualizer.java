package com.projet_t1.ihm;

import javafx.scene.Parent;
import javafx.scene.text.Text;


public class PumpVisualizer extends Parent {

    public static String Etat(Boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

    public  PumpVisualizer(){
        Text text = new Text("La pompe " + PUMP_NUMBER.get() + " est " + Etat(PUMP_STATUS.get()) );
        text.setY(15);
        this.getChildren().add(text);
    }

}
