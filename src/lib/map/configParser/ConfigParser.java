package lib.map.configParser;

import lib.map.ConfigItems;

public class ConfigParser {
    public static ConfigItems parse(String mapName, String configsRoot) {
        ConfigParser parser = new ConfigParser(mapName, configsRoot);

        return parser.parse();
    }

    private ConfigParser(String mapName, String configsRoot) {
        this.mapName = mapName;
        this.configsRoot = configsRoot;
    }

    private ConfigItems parse() {
        String[] rowsData = this.extractRowsData();

        return rowsData == null
            ? ConfigParser.createConfigItems()
            : this.doParse(rowsData);
    }

    private ConfigItems doParse(String[] rowsData) {
        return RowsDataParser.parse(rowsData);
    }

    private String[] extractRowsData() {
        return RowsDataExtractor.extract(this.mapName, this.configsRoot);
    }

    private static ConfigItems createConfigItems() {
        return new ConfigItems();
    }

    private String mapName;
    private String configsRoot;
}
