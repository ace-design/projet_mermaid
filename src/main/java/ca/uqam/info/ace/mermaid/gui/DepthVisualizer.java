package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.scene.Parent;
import javafx.scene.text.Text;

public class DepthVisualizer extends Parent {

    public DepthVisualizer (Mermaid mermaid) {
            Text text = new Text("Depth : " + mermaid.getDepth());
            this.getChildren().add(text);
            }
        }


