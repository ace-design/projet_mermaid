package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Pressure implements Law {

    private double value;
    private String name;

    public Pressure(double depth) {
        this.value = 1+ ((int) depth/10);
    }

    public Double build(double depth) {
        this.name = "pressure";
        this.value = 1 + ((int) depth/10);
        return (this.value);
    }

    public String name() {
        return this.name;
    }

}

