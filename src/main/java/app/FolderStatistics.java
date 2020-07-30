package app;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FolderStatistics {

    private String folderName;

    private Map<String, Integer> statisticsMap;

    public FolderStatistics(String folderName) {
        this.folderName = folderName;
        this.statisticsMap = new HashMap<>();
    }

    public Map<String, Integer> countOfWords() {
        File[] files = getFiles();

        for (File file : files) {
            FileStatistics fileStatistics = new FileStatistics(file, statisticsMap);
            fileStatistics.calculateCountOfWords();
        }

        return statisticsMap;
    }

    private File[] getFiles() {
        File folder = new File(folderName);
        return folder.listFiles();
    }
}
