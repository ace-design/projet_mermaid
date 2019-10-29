package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.Sensor;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SensorVisualizer extends Parent {

     private VBox Pane = new VBox();

    public SensorVisualizer(Mermaid mermaid) {

        for (Integer i = 0; i < mermaid.getNumberSensor(); i++) {
            Sensor sensor = mermaid.getlistSensor().get(i);
            double troncValue = (double) ((int) (sensor.getValue()*100))/100;  //troncature à 2 chiffres après la virgule pour l'affichage
            Text text = new Text(sensor.isName()+" : "+ troncValue );
                Pane.getChildren().add(text);
        }
        Pane.setSpacing(15);
        this.getChildren().add(Pane);

    }
}
