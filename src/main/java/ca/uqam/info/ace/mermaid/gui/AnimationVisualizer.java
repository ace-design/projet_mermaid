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

    public void Dive(Integer depthmemory){
        double depthVisuel = (mermaid.getDepth() *((240.0)/mermaid.getDepthMax())); //pour une fenetre de hauteur max 400px, 240 etant la limite du ciel en px
        TranslateTransition transition = new TranslateTransition();
        int gapDepth = Math.abs(mermaid.getDepth()-depthmemory);
        transition.setDuration(Duration.millis(((int)(0.45*gapDepth*(100/mermaid.getSpeed()))+100))); //0.45 coeff directeur d'une droite y -->(100 ; 1000) x -->(0 ; 2000) et 100/speed pour que durée min = 100/20 = 5sc
        transition.setDuration(Duration.seconds(6));
        transition.setToY((int) depthVisuel);
        transition.setNode(floteur);
        transition.play();
    }

}
