package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Temperature implements Law {

    private double value;
    private double initvalue;

    public Temperature(double depth, double initvalue ) {
        this.initvalue = initvalue;
        this.value = initvalue - ((int) (depth/1000));
    }

    public Double build(double depth) {
        this.value = initvalue - ((int) (depth/1000));
        return (this.value);
    }


}
