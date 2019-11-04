package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Salinity implements Law {

    private double value;
    private String name;


    public Salinity(double depth) {
        this.value = 3.5 + ((int) 0.01*depth);
    }

    public Double build(double depth) {
        this.name= "salinity";
        this.value = 3.5 + ((int) 0.01*depth) ;
        return (this.value);
    }

    public String name() {
        return this.name;
    }

}
