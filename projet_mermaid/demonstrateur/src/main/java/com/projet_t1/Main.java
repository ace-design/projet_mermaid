package com.projet_t1;

import com.projet_t1.ihm.MermaidVisualizer;
import com.projet_t1.mermaid_model.Mermaid;
import com.projet_t1.mermaid_model.MermaidRegistry;
import com.projet_t1.request_jersey.MermaidServer;
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









