package lib.map;

public class ConfigItem {
    public ConfigItem(int row, int col, String name) {
        this.row = row;
        this.col = col;
        this.name = name;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public String getName() {
        return this.name;
    }

    private int row;
    private int col;

    private String name;
}
