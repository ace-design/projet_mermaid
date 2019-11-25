package ca.uqam.info.ace.mermaid.mermaid.laws;

import ca.uqam.info.ace.mermaid.mermaid.Sensor;

public class LawsFactory {

    public Law getLaw(String lawType,double depth, double initValue) {

        if (lawType == null) {
            return null;
        }
        else if (lawType.equalsIgnoreCase("Hydrophone")) {
            return new Hydrophone(depth);
        }
        else if (lawType.equalsIgnoreCase("Temperature")) {
            return new Temperature(depth, initValue);
        }
        else if (lawType.equalsIgnoreCase("Salinity")) {
            return new Salinity(depth, initValue);
        }
        else if (lawType.equalsIgnoreCase("Pressure")) {
            return new Pressure(depth);
        }
        else if (lawType.equalsIgnoreCase("Light")) {
            return new Light(depth);
        }
        else if (lawType.equalsIgnoreCase("calm")) {
            return new Calm(depth);
        }
        else if (lawType.equalsIgnoreCase("agitated")) {
            return new Agitated(depth);
        }
            return null;
        }
    }


