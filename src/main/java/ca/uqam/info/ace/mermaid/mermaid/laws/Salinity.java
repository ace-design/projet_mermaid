package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Salinity implements Law {

    private double value;
    private double initvalue;



    public Salinity(double depth, double initvalue) {
        this.initvalue = initvalue;
        this.value = initvalue + ((int) 0.01*depth);
    }

    public Double build(double depth) {
        this.value = initvalue + ((int) 0.01*depth) ;
        return (this.value);
    }


}
