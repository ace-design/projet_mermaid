package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Temperature implements Law {

    private double value;
    private String name;

    public Temperature(double depth) {
        this.value = 15 - ((int) (depth/1000));
    }

    public Double build(double depth) {
        this.name = "temperature";
        this.value = 15 - ((int) (depth/1000));
        return (this.value);
    }

    public String name() {
        return this.name;
    }

}
