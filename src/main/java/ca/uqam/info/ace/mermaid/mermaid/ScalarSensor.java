package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.*;

public class ScalarSensor implements Visualizable {


    private DoubleProperty value;
    private BooleanProperty status;
    private StringProperty name;

    public double getValue() {
        return value.get();
    }
    public void setValue(int value) {
        this.value.set(value);
    }
    public boolean isStatus() {
        return status.get();
    }
    public void setStatus(boolean status) {
        this.status.set(status);
    }
    public String isName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public ScalarSensor(String name, Boolean status, Double value) {
        this.status = new SimpleBooleanProperty(status);
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleDoubleProperty(value);
    }


    @Override
    public void accept(MermaidVisualizer v) {
        Listener CapteurListener = new Listener();
        CapteurListener.Listener(status,v);
        CapteurListener.Listener(name,v);
        CapteurListener.Listener(value,v);
    }
}
