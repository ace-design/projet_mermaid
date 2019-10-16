package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class PumpVisualizer extends Parent {

    private Integer id;

    public PumpVisualizer (Integer id){
        this.id = id;
        Text text = new Text("La pompe est : "+Etat(MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getPump().isStatus()));
        this.getChildren().add(text);
    }

    public static String Etat(Boolean etat){
        if (etat) {return "Active";}
        else return "Inactive";
    }

}
