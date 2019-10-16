package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Mermaid implements Visualizable {


    private Integer id;
    private Integer numberScalarSensor;
    private StringProperty name;
    private Pump pump;
    private ArrayList<ScalarSensor> listScalarSensor;
    private IntegerProperty depth;


    public Integer getDepth() {
        return depth.get();
    }
    public void setDepth(Integer depth) {
        this.depth.set(depth);
    }
    public Integer getNumberScalarSensor() {
        return numberScalarSensor;
    }
    public ArrayList<ScalarSensor> getlistScalarSensor() {
        return listScalarSensor;
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
        this.depth = new SimpleIntegerProperty(0);
        this.numberScalarSensor=7;
        this.listScalarSensor= new ArrayList<>();
        this.id = id;
        this.pump = new Pump();
        this.name = new SimpleStringProperty("", "name", "Mermaide "+id.toString());
        for (int i = 1; i <= numberScalarSensor; i++){
            this.listScalarSensor.add(new ScalarSensor("scalarSensor"+i));
        }
    }


    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
        Listener MermaidListener = new Listener();
        MermaidListener.Listener(name,v);
        MermaidListener.Listener(depth,v);
    }
}

