package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class Mermaid implements Visualizable {

    private Integer id;
    private Integer numberScalarSensor;
    private StringProperty name;
    private Pump pump;
    private ArrayList<ScalarSensor> listScalarSensor;
    private IntegerProperty depth;
    private Integer depthMax;

    public Integer getDepthMax() {
        return depthMax;
    }
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

    public Mermaid(JSONObject mermaidObject) {

        this.depthMax = ((Long) mermaidObject.get("depthMax")).intValue();
        this.depth = new SimpleIntegerProperty(((Long) mermaidObject.get("depth")).intValue());
        this.id = ((Long) mermaidObject.get("id")).intValue();
        this.pump = new Pump();
        this.name = new SimpleStringProperty((String) mermaidObject.get("name"));
        JSONArray scalarSensorArray = (JSONArray) mermaidObject.get("scalarSensor");
        this.numberScalarSensor=scalarSensorArray.size();
        this.listScalarSensor= new ArrayList<>();
        for (int i = 0; i <= numberScalarSensor-1; i++){
            JSONObject sensor = (JSONObject) scalarSensorArray.get(i);
            this.listScalarSensor.add(new ScalarSensor( (String) sensor.get("name"),(Boolean) sensor.get("status"),((Long) sensor.get("value")).doubleValue()));
        }
    }


    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
        for (int i = 0; i <= numberScalarSensor-1; i++){
            this.listScalarSensor.get(i).accept(v);
        }
        Listener MermaidListener = new Listener();
        MermaidListener.Listener(name,v);
        MermaidListener.Listener(depth,v);
    }
}

