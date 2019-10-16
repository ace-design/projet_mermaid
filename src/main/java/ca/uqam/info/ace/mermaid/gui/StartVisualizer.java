package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import javafx.application.Application;
import javafx.stage.Stage;



public class StartVisualizer extends Application {

    @Override
    public void start(Stage InfoStage) {

        for (int i = 1; i <= MermaidRegistry.GLOBAL_REGISTRY.size(); i++) {
            Stage stage = new Stage();
            MermaidVisualizer mermaidVisualizer = new MermaidVisualizer(i,stage);
            mermaidVisualizer.attach(MermaidRegistry.GLOBAL_REGISTRY.fetch(i));
        }
        InfoVisualizer infoVisualizer = new InfoVisualizer(InfoStage);
    }

    public  static void Refresh(MermaidVisualizer v){
        v.refresh();
    }


}



