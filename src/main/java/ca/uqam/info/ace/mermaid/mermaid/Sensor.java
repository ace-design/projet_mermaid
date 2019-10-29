package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.laws.Law;
import javafx.beans.property.*;

public class Sensor implements Visualizable {


    private DoubleProperty value;
    private StringProperty name;
    private Law law;

    public Law getLaw() {
        return law;
    }
    public double getValue() {
        return value.get();
    }
    public void setValue(double value) {
        this.value.set(value);
    }
    public String isName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public Sensor(String name, Double value, Law law ){
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleDoubleProperty(value);
        this.law = law;
    }

    @Override
    public void accept(MermaidVisualizer v) {
        Listener SensorListener = new Listener();
        SensorListener.Listener(name,v);
        SensorListener.Listener(value,v);
    }
}
