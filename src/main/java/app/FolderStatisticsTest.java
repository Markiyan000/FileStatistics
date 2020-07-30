package app;

import java.util.Map;
import java.util.Set;

public class FolderStatisticsTest {

    private static <K, V> void printMap(Map<K, V> map) {
        Set<Map.Entry<K, V>> entrySet = map.entrySet();

        for (Map.Entry<K, V> current : entrySet) {
            System.out.println(current.getKey() + " : " + current.getValue());
        }
    }

    public static void main(String[] args) {
        FolderStatistics folderStatistics = new FolderStatistics("C:\\Users\\marki\\file-statistics");

        printMap(folderStatistics.countOfWords());
    }
}
