package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;


public class Pump implements Visualizable {


    private BooleanProperty status;

    public boolean isStatus() {
        return status.get();
    }
    public void setStatus(boolean status) {
        this.status.set(status);
    }


    public Pump() {
        this.status = new SimpleBooleanProperty("", "status",false);
    }

    @Override
    public void accept(MermaidVisualizer v) {
        Listener PumpListener = new Listener();
        PumpListener.Listener(status,v);
    }
}
