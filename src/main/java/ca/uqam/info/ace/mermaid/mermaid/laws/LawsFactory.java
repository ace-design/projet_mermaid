package ca.uqam.info.ace.mermaid.mermaid.laws;

import ca.uqam.info.ace.mermaid.mermaid.Sensor;

public class LawsFactory {

    public Law getLaw(String lawType, double initValue) {

        if (lawType == null) {
            return null;
        }
        else if (lawType.equalsIgnoreCase("Hydrophone")) {
            return new Hydrophone(initValue);
        }
        else if (lawType.equalsIgnoreCase("Temperature")) {
            return new Temperature(initValue);
        }
        else if (lawType.equalsIgnoreCase("Salinity")) {
            return new Salinity(initValue);
        }
        else if (lawType.equalsIgnoreCase("Pressure")) {
            return new Pressure(initValue);
        }
        else if (lawType.equalsIgnoreCase("Light")) {
            return new Light(initValue);
        }
        else if (lawType.equalsIgnoreCase("calm")) {
            return new Calm(initValue);
        }
        else if (lawType.equalsIgnoreCase("agitated")) {
            return new Agitated(initValue);
        }
            return null;
        }
    }


