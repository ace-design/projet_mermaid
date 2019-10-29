package ca.uqam.info.ace.mermaid.mermaid.laws;



public class Agitated implements Law {

    private double lastvalue;


    public Agitated(double initValue){
        this.lastvalue = initValue;
    }

    public Double build(){
        return ((Math.random()-0.5)*100);
    }
}
