package ca.uqam.info.ace.mermaid.gui;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class SkyVisualizer extends Parent {

    public Region region() {
        Region sky = new Region();
        GridPane.setConstraints(sky, 0, 0, 1, 1 );
        sky.setStyle("-fx-background-color: azure");
        sky.setPrefSize(50, 50);
        return (sky);

    }

}
