package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.application.Platform;
import javafx.beans.property.Property;

public class Listener {

    //Utilisation d'un runLater() pour exécuter le Refresh dans le thread javaFX
    public Listener(Property Prop){
        Prop.addListener((o, oldValue, newValue) -> Platform.runLater(() -> {
            MermaidVisualizer.getinstance_mermaid().Refresh(Prop);
        }));
    }
}
