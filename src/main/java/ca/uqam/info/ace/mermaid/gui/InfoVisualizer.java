package ca.uqam.info.ace.mermaid.gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class InfoVisualizer extends Parent {

    public InfoVisualizer(Stage InfoStage) {
        VBox root = new VBox();
        Scene infoscene = new Scene(root, 600, 400);
        Text initial_text = new Text("Les mermaid sont prêt à recevoir les données à l'adresse suivante :\n");
        Hyperlink link = new Hyperlink("http://localhost:8080/mermaid/info");
        link.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    URI uri = new URI("http://localhost:8080/mermaid/info");
                    Desktop.getDesktop().browse(uri);
                } catch (URISyntaxException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        root.getChildren().add(initial_text);
        root.getChildren().add(link);
        InfoStage.setScene(infoscene);
        InfoStage.setTitle("Info");
        InfoStage.show();

    }
}
