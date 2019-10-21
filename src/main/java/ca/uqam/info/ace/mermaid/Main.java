package ca.uqam.info.ace.mermaid;


import ca.uqam.info.ace.mermaid.gui.StartVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import ca.uqam.info.ace.mermaid.serveur.MermaidServer;
import javafx.application.Application;



public class Main{

    private static int numberOfmermaid = 2;

    public static void main(String[] args) throws Exception {

        MermaidServer srv = new MermaidServer();
        srv.start(8080);

        for (int i = 1; i <= numberOfmermaid; i++) {
            Mermaid m = new Mermaid(i);
            MermaidRegistry.GLOBAL_REGISTRY.register(m);
        }
         Application.launch(StartVisualizer.class);

    }

}









