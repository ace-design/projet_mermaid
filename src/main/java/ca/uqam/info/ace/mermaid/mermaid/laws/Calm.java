package ca.uqam.info.ace.mermaid.mermaid.laws;



public class Calm implements Law {

    private double lastvalue;

    public Calm(double initValue){
        this.lastvalue = initValue;
    }

    public Double build(){
        lastvalue = lastvalue + (Math.random()-0.5)*3;
        return (lastvalue) ;

    }
}
