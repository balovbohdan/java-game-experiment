package lib.map.configParser;

import gameObjectsSystem.MapPoint;
import lib.map.ConfigItem;
import lib.map.ConfigItems;

class RowsDataParser {
    static ConfigItems parse(String[] rowsData) {
        RowsDataParser factory = new RowsDataParser(rowsData);

        return factory.parse();
    }

    private RowsDataParser(String[] rowsData) {
        this.rowsData = rowsData;
        this.configItems = RowsDataParser.createConfigItems();
    }

    private ConfigItems parse() {
        int rowsQty = this.rowsData.length;

        for (int row = 0; row < rowsQty; row++)
            this.parseItemsOfRow(row);

        return this.configItems;
    }

    private void parseItemsOfRow(int row) {
        String[] itemsOfRowData = this.getItemsOfRowData(row);

        int colsQty = itemsOfRowData.length;

        for (int col = 0; col < colsQty; col++) {
            String name = itemsOfRowData[col];
            ConfigItem item = RowsDataParser.createConfigItem(row, col, name);

            this.addToConfigItems(item);
        }
    }

    private String[] getItemsOfRowData(int row) {
        String rowData = this.getRowData(row);

        return rowData.split("\\r?\\n");
    }

    private String getRowData(int row) {
        return this.rowsData[row];
    }

    private void addToConfigItems(ConfigItem item) {
        this.configItems.add(item);
    }

    private static ConfigItem createConfigItem(int row, int col, String name) {
        MapPoint mapPoint = new MapPoint(row, col);

        return new ConfigItem(mapPoint, name);
    }

    private static ConfigItems createConfigItems() {
        return new ConfigItems();
    }

    private String[] rowsData;
    private ConfigItems configItems;
}
