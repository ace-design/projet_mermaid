package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.laws.LawsFactory;
import javafx.beans.property.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class Mermaid implements Visualizable {

    private Integer periode;
    private Integer delay;
    private Integer id;
    private Integer numberSensor;
    private StringProperty name;
    private Pump pump;
    private ArrayList<Sensor> listSensor;
    private IntegerProperty depth;
    private Integer depthMax;
    private Integer speed;
    private Integer speedMax;
    private LawsFactory lawsFactory;
    private Clock clock;
    private BooleanProperty diving;

    public void setDiving(Boolean diving) {
        this.diving.set(diving);
    }
    public Boolean getDiving() {
        return diving.get();
    }
    public Clock getClock() {
        return clock;
    }
    public Integer getSpeedMax() {
        return speedMax;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    public Integer getDepthMax() {
        return depthMax;
    }
    public Integer getDepth() { return depth.get(); }
    public void setDepth(Integer depth) {
        this.depth.set(depth);
    }
    public Integer getNumberSensor() {
        return numberSensor;
    }
    public ArrayList<Sensor> getlistSensor() {
        return listSensor;
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

    public Mermaid(JSONObject config, JSONObject mermaidObject) {
        this.lawsFactory = new LawsFactory();
        this.periode =((Long) ((JSONObject) config.get("clock")).get("periode")).intValue();
        this.delay = ((Long) ((JSONObject) config.get("clock")).get("delay")).intValue();
        this.speed = ((Long) mermaidObject.get("speed")).intValue();
        this.depthMax = ((Long) ((JSONObject) config.get("generalParam")).get("depthMax")).intValue();
        this.speedMax = ((Long) ((JSONObject) config.get("generalParam")).get("speedMax")).intValue();
        this.depth = new SimpleIntegerProperty(((Long) mermaidObject.get("depth")).intValue());
        this.id = ((Long) mermaidObject.get("id")).intValue();
        this.pump = new Pump();
        this.name = new SimpleStringProperty((String) mermaidObject.get("name"));
        JSONArray scalarSensorArray = (JSONArray) mermaidObject.get("scalarSensor");
        this.numberSensor =scalarSensorArray.size();
        this.listSensor = new ArrayList<>();
        for (int i = 0; i <= numberSensor -1; i++){
            JSONObject sensor = (JSONObject) scalarSensorArray.get(i);
            this.listSensor.add(new Sensor((String) sensor.get("name"),((Long) sensor.get("value")).doubleValue(),lawsFactory.getLaw((String) sensor.get("law"),((Long) sensor.get("value")).doubleValue())));
        }
        this.clock = new Clock(delay, periode, listSensor);
        this.diving = new SimpleBooleanProperty(false);
    }


    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
        for (int i = 0; i <= numberSensor -1; i++){
            this.listSensor.get(i).accept(v);
        }
        Listener MermaidListener = new Listener();
        MermaidListener.Listener(diving,v);
        MermaidListener.Listener(name,v);
        MermaidListener.Listener(depth,v);
    }
}

