package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MermaidVisualizer extends Parent {


    private Integer id;
    private Stage stage;
    private Scene scene;
    private GridPane root;
    private PumpVisualizer pumpVisualizer;
    private AnimationVisualizer animationVisualizer;
    private Mermaid mermaid;
    private int depthmemory;


    public  MermaidVisualizer(Integer id, Stage stage) {
        this.stage = stage;
        this.id = id;
        this.root = new GridPane();
        this.pumpVisualizer = new PumpVisualizer(id);
        this.mermaid = MermaidRegistry.GLOBAL_REGISTRY.fetch(id);
        this.animationVisualizer = new AnimationVisualizer(mermaid);
        buildscene();
        this.stage.show();
    }

    public void attach(Mermaid m) {
        m.accept(this);
    }

    public void buildscene(){

        //construction de la scène
        String name = mermaid.getName().get();
        this.scene = new Scene(root, 400, 350);
        this.stage.setScene(scene);
        this.stage.setTitle(name);
        //contraintes sur le gridPane
        root.getColumnConstraints().setAll(
                new ColumnConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
                new ColumnConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
        root.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);
        RowConstraints rowConstraints = new RowConstraints(10, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE );
        root.getRowConstraints().add(rowConstraints);
        root.getRowConstraints().get(0).setVgrow(Priority.ALWAYS);
        root.setGridLinesVisible(false);
        root.setPadding(new Insets(20));
        root.setHgap(10);
        //affichage titre de la colonne
        Text title = new Text("Liste des capteurs : ");
        GridPane.setConstraints(title, 1, 0);
        root.getChildren().add(title);
        //affichage des 8 lignes disponibles pour l'affichage des capteurs
        for (int i = 1; i <= mermaid.getNumberScalarSensor(); i++) {
            root.getRowConstraints().add(rowConstraints);
        }
        //affichage de l'etat de la pompe
        GridPane.setConstraints(pumpVisualizer,1,1);
        root.getChildren().add(pumpVisualizer);
        //affichage du ciel
        SkyVisualizer skyVisualizer = new SkyVisualizer();
        root.getChildren().add(skyVisualizer.region());
        //affichage de la mer
        SeaVisualizer seaVisualizer = new SeaVisualizer();
        root.getChildren().add(seaVisualizer.region());
        //affichage de l'animation
        GridPane.setConstraints(animationVisualizer, 0, 1, 1 ,Integer.MAX_VALUE);
        GridPane.setValignment(animationVisualizer,VPos.TOP);
        GridPane.setHalignment(animationVisualizer,HPos.CENTER);
        root.getChildren().add(animationVisualizer);
        this.depthmemory = mermaid.getDepth();
    }


    public void refresh(){
        //refresh de l'etat de la pompe
        root.getChildren().remove(pumpVisualizer);
        PumpVisualizer newpumpVisualizer = new PumpVisualizer(id);
        pumpVisualizer = newpumpVisualizer;
        GridPane.setConstraints(pumpVisualizer,1,1);
        root.getChildren().add(pumpVisualizer);
        //lance l'animation pour chaque appel de nouvelle profondeur
        if (mermaid.getDepth() != depthmemory ){
            animationVisualizer.Dive(mermaid.getDepth());
            depthmemory= mermaid.getDepth();
            }
        //refresh du nom
        this.stage.setTitle(mermaid.getName().get());
    }


}


