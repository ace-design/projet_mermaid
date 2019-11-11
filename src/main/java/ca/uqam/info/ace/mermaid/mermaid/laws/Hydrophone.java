package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Hydrophone implements Law {

    private double value;

    public Hydrophone(double depth) {
        this.value =0;
    }

    public Double build(double depth) {
        this.value = 0;
        return (this.value);
    }


}
