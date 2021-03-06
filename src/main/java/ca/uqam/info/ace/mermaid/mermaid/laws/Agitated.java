package ca.uqam.info.ace.mermaid.mermaid.laws;



public class Agitated implements Law {

    private double value;

    public Agitated(double initValue) {
        this.value = initValue;
    }

    public Double build(double value) {
        this.value = Math.abs(value + (Math.random() - 0.5) * 100);
        return (this.value);
    }

}
