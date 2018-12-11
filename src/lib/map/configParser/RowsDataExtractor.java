package lib.map.configParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class RowsDataExtractor {
    static String[] extract(String mapName, String configsRoot) {
        RowsDataExtractor extractor = new RowsDataExtractor(mapName, configsRoot);

        return extractor.extract();
    }

    private RowsDataExtractor(String mapName, String configsRoot) {
        this.mapName = mapName;
        this.configsRoot = configsRoot;
    }

    private String[] extract() {
        try {
            return this.doExtract();
        } catch (IOException e) {
            System.out.println("Failed to extract game map configuration row.");

            return null;
        }
    }

    private String[] doExtract() throws IOException {
        BufferedReader bufferedReader = this.createBufferedReader();

        StringBuilder content = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String linePrepared = line + "\r\n";

            content.append(linePrepared);
        }

        return content
            .toString()
            .split("\\r?\\n\\r?\\n\\r?\\n\\r?\\n");
    }

    private BufferedReader createBufferedReader() throws IOException {
        File file = this.createFile();

        FileReader fileReader = new FileReader(file);

        return new BufferedReader(fileReader);
    }

    private File createFile() {
        String configSrc = this.getConfigSrc();

        return new File(configSrc);
    }

    private String getConfigSrc() {
        return this.configsRoot + this.mapName + ".map";
    }

    private String mapName;
    private String configsRoot;
}
