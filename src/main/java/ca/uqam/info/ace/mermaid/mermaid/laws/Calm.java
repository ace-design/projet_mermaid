package ca.uqam.info.ace.mermaid.mermaid.laws;



public class Calm implements Law {

    private double value;
    private String name;

    public Calm(double initValue){
        this.value = initValue;
        this.name = "calm";
    }

    public Double build(double value){
        this.value = value + (Math.random()-0.5)*3;
        return (this.value) ;
    }

    public String name() {
        return this.name;
    }

}
