package com.projet_t1.mermaid_model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.text.Text;

public class Pump extends Mermaid{

    public static BooleanProperty PUMP_STATUS = new SimpleBooleanProperty("", "PUMP_STATUS",false);
    public static IntegerProperty PUMP_NUMBER = new SimpleIntegerProperty("", "PUMP_NUMBER", 0);



}
