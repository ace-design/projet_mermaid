package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.beans.property.StringProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MermaidVisualizer extends Parent {


    public Integer getid() {
        return id;
    }

    private Integer id;
    private Stage stage;
    private Scene scene;

    public  MermaidVisualizer(Integer id, Stage stage) {
        this.stage = stage;
        this.id = id;
        buidscene();
        this.stage.show();
    }

    public void attach(Mermaid m) {
        m.accept(this);
    }

    public void buidscene(){
        Region region = new Region();
        GridPane.setConstraints(region, 0, 0, 1, Integer.MAX_VALUE);
        region.setStyle("-fx-background-color: azure; -fx-border-color: beige;");
        region.setPrefSize(100, 100);
        GridPane root = new GridPane();
        //
        root.getColumnConstraints().setAll(
                new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
                new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
        root.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);
        //
        root.getRowConstraints().setAll(
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
        root.getRowConstraints().get(0).setVgrow(Priority.NEVER);
        root.getRowConstraints().get(1).setVgrow(Priority.NEVER);
        root.getRowConstraints().get(2).setVgrow(Priority.ALWAYS);
        //
        StringProperty name = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getName();
        Text initial_text = new Text("Je suis :  \n"+name.get());
        GridPane.setConstraints(initial_text, 1, 0);
//        Text text1 = new Text("Je suis :  \n"+MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getCapteur1().isName());
//        GridPane.setConstraints(text1, 1, 1);
//        Text text2 = new Text("Je suis :  \n"+MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getCapteur2().isName());
//        GridPane.setConstraints(text2, 1, 1);
//        Text text3 = new Text("Je suis :  \n"+MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getCapteur3().isName());
//        GridPane.setConstraints(text3, 1, 1);
//        root.getChildren().setAll(text1,text2,text3);
        root.getChildren().add(region);
        root.getChildren().add(initial_text);
        this.scene = new Scene(root, 400, 350);
        this.stage.setScene(scene);
        this.stage.setTitle(name.get());
    }
}


