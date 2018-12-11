package lib.map.configParser;

import gameObjectsSystem.MapPoint;
import lib.map.ConfigItem;
import lib.map.ConfigItems;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        int col = 0;

        for (String configLine : itemsOfRowData) {
            Boolean configLineRepresentsParams = RowsDataParser.isConfigLineRepresentsParams(configLine);

            if (configLineRepresentsParams) {
                this.addParamsToLastConfigItems(configLine);
            } else {
                this.addToConfigItems(row, col, configLine);

                ++col;
            }
        }
    }

    private void addParamsToLastConfigItems(String configLine) {
        Point offsets = this.extractGameObjectOffsets(configLine);

        this.updateLastConfigItem(offsets);
    }

    private Point extractGameObjectOffsets(String configLine) {
        Pattern pattern = Pattern.compile("(?i)^ {4}- \\w+: (.+)");
        Matcher matcher = pattern.matcher(configLine);

        boolean resultExists = matcher.find();

        if (!resultExists)
            return null;

        String result = matcher.group(1);

        int xOffset = Integer.parseInt(result);

        return new Point(xOffset, 0);
    }

    private void addToConfigItems(int row, int col, String configLine) {
        ConfigItem item = RowsDataParser.createConfigItem(row, col, configLine);

        this.configItems.add(item);
    }

    private void updateLastConfigItem(Point offsets) {
        ConfigItem lastConfigItem = this.configItems.getLast();

        lastConfigItem.setOffsets(offsets);
    }

    private String[] getItemsOfRowData(int row) {
        String rowData = this.getRowData(row);

        return rowData.split("\\r?\\n");
    }

    private String getRowData(int row) {
        return this.rowsData[row];
    }

    private static Boolean isConfigLineRepresentsParams(String configLine) {
        return configLine.matches("(?i)^ {4}- \\w+: .+");
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
