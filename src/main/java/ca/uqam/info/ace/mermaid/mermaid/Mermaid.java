package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mermaid implements Visualizable {


    private Integer id;
    private StringProperty name;
    private Pump pump;

    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public Pump getPump() {
        return pump;
    }

    public Mermaid(Integer id) {
        this.id = id;
        this.pump = new Pump(1);
        this.name = new SimpleStringProperty("", "name", "Mermaide n°"+id.toString());
    }


    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
        Listener MermaidListener = new Listener();
        MermaidListener.Listener(name,v);
    }
}

