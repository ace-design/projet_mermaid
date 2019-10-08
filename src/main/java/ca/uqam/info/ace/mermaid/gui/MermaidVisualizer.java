package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
        StringProperty name = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getName();
        GridPane root = new GridPane();
        this.scene = new Scene(root, 600, 400);
        Text initial_text = new Text("Je suis :  \n"+name.get());
        initial_text.setX(50);
        initial_text.setY(50);
        root.getChildren().add(initial_text);
        this.stage.setScene(scene);
        this.stage.setTitle(name.get());
        this.stage.show();
    }

    public void attach(Mermaid m) {
        m.accept(this);
    }

    public void refresh(){
        StringProperty name = MermaidRegistry.GLOBAL_REGISTRY.fetch(id).getName();
        GridPane root = new GridPane();
        this.scene = new Scene(root, 400, 350);
        Text initial_text = new Text("Je suis :  \n"+name.get());
        initial_text.setX(50);
        initial_text.setY(50);
        root.getChildren().add(initial_text);
        this.stage.setScene(scene);
        this.stage.setTitle(name.get());
    }
}


