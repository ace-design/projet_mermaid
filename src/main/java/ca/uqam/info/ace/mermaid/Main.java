package ca.uqam.info.ace.mermaid;


import ca.uqam.info.ace.mermaid.gui.StartVisualizer;
import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import ca.uqam.info.ace.mermaid.mermaid.MermaidRegistry;
import ca.uqam.info.ace.mermaid.serveur.MermaidServer;
import javafx.application.Application;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.net.URL;


public class Main {


    public static void main(String[] args) throws Exception {

        //Recuperation du fichier de configuration dans les ressources
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource("config.json");
        File file = new File(resource.getFile());
        Object obj = new JSONParser().parse(new FileReader(file));
        JSONObject config = (JSONObject) obj;

        //Récuperation du numero de port du serveur et demarage du serveur
        Long port = (Long) config.get("port");
        MermaidServer srv = new MermaidServer();
        srv.start(port.intValue());

        //Création des mermaids selon le fichier de configuration
        JSONArray mermaidArray = (JSONArray) config.get("mermaids");
        for (int i = 0; i < mermaidArray.size(); i++) {
            JSONObject mermaidObject = (JSONObject) mermaidArray.get(i) ;
            Mermaid m = new Mermaid(mermaidObject);
            MermaidRegistry.GLOBAL_REGISTRY.register(m);
        }
        Application.launch(StartVisualizer.class);
    }


}









