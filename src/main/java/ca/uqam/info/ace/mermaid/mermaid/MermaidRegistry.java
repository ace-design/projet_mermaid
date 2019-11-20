package ca.uqam.info.ace.mermaid.mermaid;

import java.util.HashMap;
import java.util.Map;

public class MermaidRegistry {

    public static final MermaidRegistry GLOBAL_REGISTRY = new MermaidRegistry();

    private Map<Integer, Mermaid> registry = new HashMap<Integer, Mermaid>();

    public Map<Integer, Mermaid> getRegistry() {
        return registry;
    }

    public void register(Mermaid m) {
        registry.put(m.getId(), m);
    }

    public Mermaid fetch(Integer n) {
        return registry.get(n);
    }

    public int size(){
        return(registry.size());
    }

}
