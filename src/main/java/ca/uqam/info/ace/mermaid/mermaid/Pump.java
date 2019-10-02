package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pump implements Visualizable {

    public boolean isStatus() {
        return status.get();
    }
    public BooleanProperty statusProperty() {
        return status;
    }
    public int getNumber() {
        return number.get();
    }
    public IntegerProperty numberProperty() {
        return number;
    }

    private BooleanProperty status;

    public void setStatus(boolean status) {
        this.status.set(status);
    }
    public void setNumber(int number) {
        this.number.set(number);
    }


    private IntegerProperty number;
    public Pump(int pumpNumber) {
        this.status = new SimpleBooleanProperty("", "status",false);
        this.number = new SimpleIntegerProperty("", "number", pumpNumber);
    }

    @Override
    public void accept(MermaidVisualizer v) {
        status.addListener((o, oldValue, newValue) -> Platform.runLater(() -> {
            MermaidVisualizer.getinstance_mermaid().Refresh(status);
        }));
        number.addListener((o, oldValue, newValue) -> Platform.runLater(() -> {
            MermaidVisualizer.getinstance_mermaid().Refresh(number);
        }));
    }
}
