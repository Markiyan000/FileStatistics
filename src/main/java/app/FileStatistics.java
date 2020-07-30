package app;

import java.io.*;
import java.util.Map;

public class FileStatistics {

    private File file;

    private Map<String, Integer> statisticsMap;

    public FileStatistics(File file, Map<String, Integer> statisticsMap) {
        this.file = file;
        this.statisticsMap = statisticsMap;
    }

    private BufferedReader createFileReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }

    private void putToMap(String[] words) {
        for (String currentWord : words) {
            Integer countOfWords = statisticsMap.get(currentWord);

            if (countOfWords == null) {
                statisticsMap.put(currentWord, 1);
            } else {
                statisticsMap.put(currentWord, countOfWords + 1);
            }
        }
    }

    public void calculateCountOfWords() {
        String line;

        try (BufferedReader bufferedReader = createFileReader()) {
            while ((line = bufferedReader.readLine()) != null) {
                putToMap(line.split(" "));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
