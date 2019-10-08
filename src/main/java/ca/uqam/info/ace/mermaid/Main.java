package ca.uqam.info.ace.mermaid;


import ca.uqam.info.ace.mermaid.gui.StartVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import ca.uqam.info.ace.mermaid.serveur.MermaidServer;
import javafx.application.Application;



public class Main{



    public static void main(String[] args) throws Exception {

        MermaidServer srv = new MermaidServer();
        srv.start(8080);

        for (int i = 1; i <= 2; i++) {
            Mermaid m = new Mermaid(i);
            MermaidRegistry.GLOBAL_REGISTRY.register(m);
        }
         StartVisualizer startVisualizer = new StartVisualizer();
         Application.launch(StartVisualizer.class);

    }

}









