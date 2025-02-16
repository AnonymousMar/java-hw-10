package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

public class FileJsonContentTest {
    public static void main(String[] args) throws IOException {
        FileJsonContentReader fileJsonContentReader = new ScannnerJsonContentReader();
        String content =  fileJsonContentReader.read(new File("files/json.txt"));
        List<User> users = FileJsonContentUser.partsUsers(content);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(users);
        System.out.println("json = " + json);
        FileOutputStream fos = new FileOutputStream("files/user.json");
        fos.write(json.getBytes());
        fos.flush();
        fos.close();
    }
}
