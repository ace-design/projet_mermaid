package com.projet_t1.ihm;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;




public class MermaidVisualizer extends Application {


    private static MermaidVisualizer intance_mermaid;

    public static MermaidVisualizer getinstance_mermaid(){
        if (intance_mermaid == null) {
            intance_mermaid = new MermaidVisualizer();
        }
        return intance_mermaid;
    }

    public static Group root;

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        Scene scene = new Scene(root, 400, 350);
        Text text = new Text("Prêt à recevoir les données de la pompe à l'adresse \n “http://localhost:8080/pump/{id}/{state}“");
        text.setTranslateX(30);
        text.setTranslateY(100);
        root.getChildren().add(text);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etat de la pompe");
        primaryStage.show();
    }

    public void Refresh(){
        root.getChildren().clear();
        Affichage text = new Affichage();
        text.setTranslateX(30);
        text.setTranslateY(100);
        root.getChildren().add(text);
        }
    }



