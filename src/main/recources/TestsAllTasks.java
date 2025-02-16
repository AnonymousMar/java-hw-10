package main.recources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.recources.NumberValid.CheckIfValid;
import main.recources.howManyWords.HowManyWordsCount;
import main.recources.json.FileJsonContentUser;
import main.recources.json.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestsAllTasks {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileContentReader fileContentReader = new ScannerContentReader();
            String content = fileContentReader.read(new File("files/words.txt"));
            String[] words = content.split("\\s+");
            System.out.println("This task is called:'how many words'");
            HowManyWordsCount howManyWordsCount = new HowManyWordsCount();

            List<Map.Entry<String,Integer>> listSorted = howManyWordsCount.countWords(words);

            for (Map.Entry<String, Integer> entry : listSorted) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            String contentJson =  fileContentReader.read(new File("files/json.txt"));
            List<User> users = FileJsonContentUser.partsUsers(contentJson);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(users);
            System.out.println("This task is called:'json'");
            System.out.println(json);
            try(FileOutputStream fos = new FileOutputStream("files/user.json")) {
                fos.write(json.getBytes());
                fos.flush();
            }

            String contentPhones = fileContentReader.read(new File("files/file.txt"));

            String[] lines = contentPhones.split("\n");
            System.out.println("This task is called:'valid phone number'");
            for (String c : lines) {
                if (CheckIfValid.isValidPhone(c)) {
                    System.out.println(c);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
