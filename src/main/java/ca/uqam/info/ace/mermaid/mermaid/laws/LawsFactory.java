package ca.uqam.info.ace.mermaid.mermaid.laws;

import ca.uqam.info.ace.mermaid.mermaid.Sensor;

public class LawsFactory {

    public Law getLaw(String lawType, double initValue) {

        if (lawType == null) {
            return null;
        }
        if (lawType.equalsIgnoreCase("calm")) {
            return new Calm(initValue);

        } else if (lawType.equalsIgnoreCase("agitated")) {
            return new Agitated(initValue);
        }
            return null;
        }
    }

