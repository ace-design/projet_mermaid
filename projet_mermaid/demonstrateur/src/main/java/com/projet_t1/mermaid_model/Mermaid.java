package com.projet_t1.mermaid_model;

import com.projet_t1.ihm.MermaidVisualizer;

public class Mermaid implements Visualizable {


    private String name;
    private Pump pump;

    public String getName() {
        return name;
    }

    public Pump getPump() {
        return pump;
    }

    public Mermaid(String name) {
        this.name = name;
        this.pump = new Pump(1);
    }

    @Override
    public void accept(MermaidVisualizer v) {
        this.pump.accept(v);
    }
}

