package ca.uqam.info.ace.mermaid.gui;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class SeaVisualizer extends Parent {

    public Region region() {
        Region sea = new Region();
        GridPane.setConstraints(sea, 0, 1, 1, Integer.MAX_VALUE);
        sea.setStyle("-fx-background-color: azure;");
        sea.setPrefSize(100, 100);
        return (sea);

    }

}
