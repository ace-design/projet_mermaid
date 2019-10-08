package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mermaid implements Visualizable {


    private Integer id;
    private StringProperty name;
    private Pump pump;
    private Capteur capteur1;
    private Capteur capteur2;
    private Capteur capteur3;

    public Capteur getCapteur1() {
        return capteur1;
    }
    public Capteur getCapteur2() {
        return capteur2;
    }
    public Capteur getCapteur3() {
        return capteur3;
    }
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
        this.capteur1 = new Capteur("capteur1");
        this.capteur2 = new Capteur("capteur2");
        this.capteur3 = new Capteur("capteur3");
    }


    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
        Listener MermaidListener = new Listener();
        MermaidListener.Listener(name,v);
    }
}

