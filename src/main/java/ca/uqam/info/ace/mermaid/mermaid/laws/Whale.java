package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Whale implements Law {

    private double value;

    public Whale(double initValue){
        this.value = initValue;
    }

    public Double build(double value){
        this.value = Math.abs(value + (Math.random()-0.5)*3);
        return (this.value) ;
    }
}
