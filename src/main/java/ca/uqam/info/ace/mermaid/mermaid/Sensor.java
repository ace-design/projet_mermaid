package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.laws.Law;
import ca.uqam.info.ace.mermaid.mermaid.laws.LawsFactory;
import javafx.beans.property.*;

public class Sensor implements Visualizable {

    private Mermaid mermaid;
    private DoubleProperty value;
    private StringProperty name;
    private Law variationLaw;
    private Law behaviorLaw;
    private LawsFactory lawsFactory;


    public void setVariationLaw(Law variationLaw) {
        this.variationLaw = variationLaw;
    }
    public String getVariationLaw() { return variationLaw.toString(); }
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

    public Sensor(Mermaid mermaid, String name, Double initvalue, Law law ){
        this.mermaid = mermaid;
        this.lawsFactory = new LawsFactory();
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleDoubleProperty(initvalue);
        this.variationLaw = law;
        this.behaviorLaw = lawsFactory.getLaw(name,mermaid.getDepth(),initvalue);
        setValue(behaviorLaw.build(mermaid.getDepth()));
    }

    public void udapte(){
        if (behaviorLaw != null) {
            setValue(behaviorLaw.build(mermaid.getDepth()));
        }
        if (variationLaw != null) {
            setValue(variationLaw.build(value.get()));
        }
        if (value.get() >= 250){
            mermaid.getMemory().getListe().add((int) value.get());
        }
    }

    @Override
    public void accept(MermaidVisualizer v) {
        Listener SensorListener = new Listener();
        SensorListener.Listener(name,v);
        SensorListener.Listener(value,v);
    }
}
