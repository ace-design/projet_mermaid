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

import java.awt.event.ActionEvent;


public class AnimationVisualizer extends Parent {

    private Circle floteur;
    private Mermaid mermaid;


    public AnimationVisualizer(Mermaid m) {
        this.mermaid = m;
        StackPane pane = new StackPane();
        floteur = new Circle(20, Color.RED);
        pane.getChildren().add(floteur);
        pane.setAlignment(floteur,Pos.CENTER );
        this.getChildren().add(pane);
    }

    public void Dive(){
        mermaid.setDiving(true);
        double depthVisuel = (mermaid.getDepthToGo() *((225.0)/mermaid.getDepthMax())); //pour une fenetre de hauteur max 400px, 225 etant la limite du ciel en px
        TranslateTransition transition = new TranslateTransition();
        int gapDepth = Math.abs(mermaid.getDepth()-mermaid.getDepthToGo());
        transition.setDuration(Duration.millis((gapDepth/mermaid.getSpeed())*1000+100));
        transition.setToY(depthVisuel);
        transition.setNode(floteur);
        transition.play();
        transition.setOnFinished(ActionEvent -> Platform.runLater(() -> {
            mermaid.setDiving(false);
        }));
    }

}
