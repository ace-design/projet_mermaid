package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Whale implements Law {

    private double value;

    public Whale(double initValue) {
        this.value = initValue;
    }

    public Double build(double value) {
        this.value = Math.abs(this.value + (Math.random() - 0.5) * 10);
        return (this.value);
    }
}




