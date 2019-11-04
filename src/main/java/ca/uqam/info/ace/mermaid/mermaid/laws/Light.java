package ca.uqam.info.ace.mermaid.mermaid.laws;

public class Light implements Law {

    private double value;
    private String name;

    public Light(double depth) {
        this.value = depth;
        this.name = "light";
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

    public String name() {
        return this.name;
    }


}
