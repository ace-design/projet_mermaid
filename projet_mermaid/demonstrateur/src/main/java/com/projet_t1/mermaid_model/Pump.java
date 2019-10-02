package com.projet_t1.mermaid_model;

import com.projet_t1.ihm.MermaidVisualizer;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pump implements Visualizable {

    private BooleanProperty status;
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
