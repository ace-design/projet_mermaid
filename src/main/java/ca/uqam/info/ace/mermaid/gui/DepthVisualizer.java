package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.scene.Parent;
import javafx.scene.text.Text;

public class DepthVisualizer extends Parent {

    private Integer id;

    public DepthVisualizer (Integer id, boolean pumpStatus) {
        this.id = id;
        if (!pumpStatus) {
            Text text = new Text("Depth : " + MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getDepth());
            this.getChildren().add(text);
        }
        else {
                Text text = new Text("Go to depth : " + MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getDepth());
                this.getChildren().add(text);
            }
        }

}
