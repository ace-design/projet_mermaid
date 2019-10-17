package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.ScalarSensor;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ScalarSensorVisualizer extends Parent {

     private VBox scalarPane = new VBox();

    public  ScalarSensorVisualizer(Mermaid mermaid) {

        for (Integer i = 0; i < mermaid.getNumberScalarSensor(); i++) {
            ScalarSensor sensor = mermaid.getlistScalarSensor().get(i);
            if (sensor.isStatus()) {
                Text text = new Text(sensor.isName()+" : "+ sensor.getValue());
                scalarPane.getChildren().add(text);
            }
        }
        scalarPane.setSpacing(15);
        this.getChildren().add(scalarPane);

    }
}
