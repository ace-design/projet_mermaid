package ca.uqam.info.ace.mermaid.mermaid;

import java.util.ArrayList;

public class Memory {

    private ArrayList liste = new ArrayList();
    private String name;

    public Memory(String name){
        this.name = "memory "+name;
    }

    public ArrayList getListe() {
        return liste;
    }

}
