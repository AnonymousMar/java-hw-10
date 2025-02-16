package howManyWords;

import java.io.File;
import java.util.*;

public class FileContentWordsTest {
    private static Object Collections;

    public static void main(String[] args) {
        FileContentWordsReader fileContentWordsReader = new ScannerWordsReader();
        String content = fileContentWordsReader.read(new File("files/words.txt"));
        String[] words = content.split("\\s+");

        HowManyWordsCount howManyWordsCount = new HowManyWordsCount();

       List<Map.Entry<String,Integer>> listSorted = howManyWordsCount.CountWords(words);

        for (Map.Entry<String, Integer> entry : listSorted) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        }


    }


