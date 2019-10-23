package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MermaidVisualizer extends Parent {


    private Integer id;
    private Stage stage;
    private Scene scene;
    private GridPane root;
    private PumpVisualizer pumpVisualizer;
    private AnimationVisualizer animationVisualizer;
    private ScalarSensorVisualizer scalarSensorVisualizer;
    private DepthVisualizer depthVisualiser;
    private Mermaid mermaid;
    private int depthmemory;


    public  MermaidVisualizer(Integer id, Stage stage) {
        this.stage = stage;
        this.id = id;
        this.root = new GridPane();
        this.pumpVisualizer = new PumpVisualizer(id);
        this.mermaid = MermaidRegistry.GLOBAL_REGISTRY.fetch(id);
        this.animationVisualizer = new AnimationVisualizer(mermaid);
        this.scalarSensorVisualizer = new ScalarSensorVisualizer(mermaid);
        this.depthVisualiser = new DepthVisualizer(id, mermaid.getPump().isStatus() );
        this.depthmemory = 0;
        buildscene();
    }

    public void attach(Mermaid m) {
        m.accept(this);
    }

    public void buildscene(){

        //construction de la scène
        String name = mermaid.getName().get();
        this.scene = new Scene(root, 500, 400);
        this.stage.setScene(scene);
        this.stage.setTitle(name);
        //contraintes sur le gridPane
        root.getColumnConstraints().setAll(
                new ColumnConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
                new ColumnConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
        root.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);
        //root.getRowConstraints().add(rowConstraints);
        root.setGridLinesVisible(false);
        root.setPadding(new Insets(20));
        root.setVgap(5);
        root.setHgap(10);

        //création des 10 lignes disponibles pour l'affichage des capteurs/pompe/...
        for (int i = 1; i <= 10; i++) {
            root.getRowConstraints().add(new RowConstraints(20, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE ));
            root.getRowConstraints().get(i-1).setVgrow(Priority.ALWAYS);
        }

        //affichage de l'Id du mermaid
        Text IdText = new Text("Id : "+mermaid.getId());
        GridPane.setConstraints(IdText, 1, 0);
        root.getChildren().add(IdText);

        //affichage de l'etat de la pompe
        GridPane.setConstraints(pumpVisualizer,1,1);
        root.getChildren().add(pumpVisualizer);

  //A faire : go to depth...
        //affichage de l'etat de la profondeur
        GridPane.setConstraints(depthVisualiser,1,2);
        root.getChildren().add(depthVisualiser);

        //affichage titre de la colonne
        Text title = new Text("Active sensor : " );
        title.setFont(Font.font(null, FontWeight.EXTRA_BOLD,14));
        GridPane.setConstraints(title, 1, 4);
        root.getChildren().add(title);

        //affichage des capteurs scalaire
        GridPane.setConstraints(scalarSensorVisualizer,1,6);
        root.getChildren().add(scalarSensorVisualizer);

        //affichage de la mer
        SeaVisualizer seaVisualizer = new SeaVisualizer();
        root.getChildren().add(seaVisualizer.region());

        //affichage du ciel
        SkyVisualizer skyVisualizer = new SkyVisualizer();
        root.getChildren().add(skyVisualizer.region());

        //affichage de l'animation
        GridPane.setConstraints(animationVisualizer, 0, 1, 1 ,Integer.MAX_VALUE);
        GridPane.setValignment(animationVisualizer,VPos.TOP);
        GridPane.setHalignment(animationVisualizer,HPos.CENTER);
        root.getChildren().add(animationVisualizer);
        refresh();
    }


    public void refresh(){
        //refresh de la profondeur
        root.getChildren().remove(depthVisualiser);
        DepthVisualizer newdepthVisualizer = new DepthVisualizer(id, mermaid.getPump().isStatus());
        depthVisualiser = newdepthVisualizer;
        GridPane.setConstraints(depthVisualiser,1,2);
        root.getChildren().add(depthVisualiser);
        //refresh des capteurs
        root.getChildren().remove(scalarSensorVisualizer);
        ScalarSensorVisualizer newscalarSensorVisualizer = new ScalarSensorVisualizer(mermaid);
        scalarSensorVisualizer = newscalarSensorVisualizer;
        GridPane.setValignment(scalarSensorVisualizer,VPos.TOP);
        GridPane.setConstraints(scalarSensorVisualizer,1,6);
        root.getChildren().add(scalarSensorVisualizer);
        //refresh du nom du mermaid
        this.stage.setTitle(mermaid.getName().get());
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
    }


}


