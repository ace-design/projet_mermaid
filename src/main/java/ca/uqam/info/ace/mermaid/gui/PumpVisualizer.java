package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.scene.Parent;
import javafx.scene.text.Text;


public class PumpVisualizer extends Parent {

    public static String Etat(Boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

    public  PumpVisualizer(){
        Text text = new Text("La pompe " + MermaidRegistry.GLOBAL_REGISTRY.fetch("1").getPump().getNumber() + " est " + Etat(MermaidRegistry.GLOBAL_REGISTRY.fetch("1").getPump().isStatus()) );
        text.setY(15);
        this.getChildren().add(text);
    }

}
