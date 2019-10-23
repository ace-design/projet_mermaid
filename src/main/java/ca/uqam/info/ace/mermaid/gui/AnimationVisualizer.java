package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class AnimationVisualizer extends Parent {

    private Circle floteur;
    Mermaid mermaid;


    public AnimationVisualizer(Mermaid m) {
        this.mermaid = m;
        StackPane pane = new StackPane();
        floteur = new Circle(20, Color.RED);
        pane.getChildren().add(floteur);
        pane.setAlignment(floteur,Pos.CENTER );
        this.getChildren().add(pane);
    }

    //rajouter la profondeur max et une notion de vitesse (temps de l'animation prop à la profondeur et la vitessse choisie)
    //modifier la pression : 10*depth
    public void Dive(Integer depth){
        mermaid.getPump().setStatus(true);
        double depthVisuel = (depth*((240.0)/mermaid.getDepthMax()));
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(6));
        transition.setToY((int) depthVisuel);
        transition.setNode(floteur);
        transition.play();
        transition.setOnFinished(actionEvent -> Platform.runLater(() -> {
            mermaid.getPump().setStatus(false);
        }));
    }

}
