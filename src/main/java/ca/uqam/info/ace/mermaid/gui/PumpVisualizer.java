package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import javafx.scene.Parent;
import javafx.scene.text.Text;


public class PumpVisualizer extends Parent {

    public PumpVisualizer (Mermaid mermaid){
        Text text = new Text("Pump status : "+Etat(mermaid.getPump().isStatus()));
        this.getChildren().add(text);
    }

    public static String Etat(boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

}
