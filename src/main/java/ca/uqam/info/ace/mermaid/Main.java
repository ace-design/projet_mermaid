package ca.uqam.info.ace.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import ca.uqam.info.ace.mermaid.serveur.MermaidServer;
import javafx.application.Application;



public class Main {

    public static void main(String[] args) throws Exception {

        MermaidServer srv = new MermaidServer();
        srv.start(8080);

        Mermaid m = new Mermaid("1");
        MermaidRegistry.GLOBAL_REGISTRY.register(m);
        MermaidVisualizer v = new MermaidVisualizer();
        v.attach(m);


        Application.launch(MermaidVisualizer.class);
    }
}









