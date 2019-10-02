package ca.uqam.info.ace.mermaid.mermaid;

import java.util.HashMap;
import java.util.Map;

public class MermaidRegistry {

    public static final MermaidRegistry GLOBAL_REGISTRY = new MermaidRegistry();

    private Map<String, Mermaid> registry = new HashMap<>();

    public void register(Mermaid m) {
        registry.put(m.getName(), m);
    }

    public Mermaid fetch(String n) {
        return registry.get(n);
    }

}
