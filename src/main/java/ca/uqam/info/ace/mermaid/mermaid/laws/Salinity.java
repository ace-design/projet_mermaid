package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Salinity implements Law {

    private double value;


    public Salinity(double depth) {
        this.value = 3.5 + ((int) 0.01*depth);
    }

    public Double build(double depth) {
        this.value = 3.5 + ((int) 0.01*depth) ;
        return (this.value);
    }


}
