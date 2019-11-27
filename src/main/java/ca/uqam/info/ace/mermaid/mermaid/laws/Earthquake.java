package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Earthquake implements Law {

    private double value;

    public Earthquake(double initValue) {
        this.value = initValue;
    }

    public Double build(double value) {
        this.value = Math.abs(this.value + (Math.random() - 0.5) * 100);
        return (this.value);
    }


}




