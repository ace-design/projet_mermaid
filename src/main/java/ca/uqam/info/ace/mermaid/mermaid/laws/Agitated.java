package ca.uqam.info.ace.mermaid.mermaid.laws;



public class Agitated implements Law {

    private double value;
    private  String name;

    public Agitated(double initValue) {
        this.value = initValue;
        this.name = "agitated";
    }

    public Double build(double value) {
        this.value = value + (Math.random() - 0.5) * 100;
        return (this.value);
    }

    public String name() {
        return this.name;
    }

}
