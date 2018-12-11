package lib.map;

import java.util.ArrayList;
import java.util.function.Function;

public class ConfigItems {
    public int getQty() {
        return this.items.size();
    }
    public void add(ConfigItem item) {
        this.items.add(item);
    }

    public void forEach(Function<ConfigItem, Boolean> callback) {
        for (ConfigItem item : this.items)
            callback.apply(item);
    }

    public ConfigItem getLast() {
        int itemsQty = this.items.size();

        int lastItemIndex = itemsQty - 1;

        return lastItemIndex < 0
            ? null
            : this.items.get(lastItemIndex);
    }

    private ArrayList<ConfigItem> items = new ArrayList<>();
}
