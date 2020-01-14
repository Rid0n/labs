import items.DepletableLightSource;

import java.util.ArrayList;

public class Action {
    private ArrayList<DepletableLightSource> Light_sources = new ArrayList<DepletableLightSource>();
    public void addLightToList(DepletableLightSource dls){
        Light_sources.add(dls);
    }
    public void refreshEnvironment() {
        for (DepletableLightSource i : Light_sources) {
            i.burn_fuel();
        }
    }
}
