package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import ca.uqam.info.ace.mermaid.gui.StartVisualizer;
import javafx.application.Platform;
import javafx.beans.property.Property;

public class Listener {

    //Utilisation d'un runLater() pour exécuter le Refresh dans le thread javaFX
    public void Listener(Property Prop, MermaidVisualizer v){
        Prop.addListener((o, oldValue, newValue) -> Platform.runLater(() -> {
            StartVisualizer.Refresh(v);
        }));
    }
}
