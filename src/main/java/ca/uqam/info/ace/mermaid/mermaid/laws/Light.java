package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Light implements Law {

    private double value;

    public Light(double depth) {
        this.value = depth;
    }

    public Double build(double depth) {
        if (depth >= 1000) {
            this.value = 0;
        }
        else {
            this.value=  100- ((int)depth/10);
        }
        return (this.value);
    }

}
