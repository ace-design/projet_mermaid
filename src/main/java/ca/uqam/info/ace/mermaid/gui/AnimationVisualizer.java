package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;

public class AnimationVisualizer extends Parent {

    private Circle floteur;
    Mermaid mermaid;


    public AnimationVisualizer(Mermaid m) {
        this.mermaid = m;
        StackPane pane = new StackPane();
        floteur = new Circle(20, Color.RED);
        pane.getChildren().add(floteur);
        pane.setAlignment(floteur, Pos.CENTER);
        this.getChildren().add(pane);
    }

    public void Dive(Integer depth){
        mermaid.getPump().setStatus(true);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(6));
        transition.setToY(depth);
        transition.setNode(floteur);
        transition.play();
        transition.setOnFinished(actionEvent -> Platform.runLater(() -> {
            mermaid.getPump().setStatus(false);
        }));
    }

}
