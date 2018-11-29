package lib.map;

import java.util.ArrayList;
import java.util.function.Function;

public class ConfigItems {
    public void add(ConfigItem item) {
        this.items.add(item);
    }

    public void forEach(Function<ConfigItem, Boolean> callback) {
        for (ConfigItem item : this.items)
            callback.apply(item);
    }

    private ArrayList<ConfigItem> items = new ArrayList<>();
}
