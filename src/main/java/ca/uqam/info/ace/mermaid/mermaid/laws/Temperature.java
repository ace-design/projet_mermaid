package ca.uqam.info.ace.mermaid.mermaid.laws;


public class Temperature implements Law {

    private double value;
    private double initvalue;

    public Temperature(double depth, double initvalue) {
        this.initvalue = initvalue;
        build(depth);
    }

    public Double build(double depth) {
        if (depth <= 250) {
            this.value = initvalue - (depth * 0.01);
            return (this.value);
        } else if (depth > 250 && depth <= 750) {
            this.value = 22 - (depth * 0.02);
            return (this.value);
        } else {
            this.value = 5 - (depth * 0.0008);
            return (this.value);
        }
    }

}









