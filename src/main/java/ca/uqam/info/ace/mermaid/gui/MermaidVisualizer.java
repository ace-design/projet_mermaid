package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MermaidVisualizer extends Application {


    private static MermaidVisualizer intance_mermaid;

    public static MermaidVisualizer getinstance_mermaid(){
        if (intance_mermaid == null) {
            intance_mermaid = new MermaidVisualizer();
        }
        return intance_mermaid;
    }

    public static Group root = new Group();

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(root, 400, 350);
        Text initial_text = new Text("Prêt à recevoir les données de la pompe à l'adresse \n  “http://localhost:8080/pump/{id}/{state}“");
        initial_text.setX(50);
        initial_text.setY(50);
        root.getChildren().add(initial_text);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etat de la pompe");
        primaryStage.show();
    }

    public void Refresh(Property Prop){
        root.getChildren().clear();
        root.getChildren().add((new PumpVisualizer()));
        Text refreshtext = new Text("La variable " + Prop.getName() + " viens d'être modifiée \nsa nouvelle valeur est : " + Prop.getValue());
        refreshtext.setY(60);
        root.getChildren().add(refreshtext);

    }

    public void attach(Mermaid m) {
        m.accept(this);
    }


}



