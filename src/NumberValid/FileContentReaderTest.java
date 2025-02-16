package NumberValid;

import java.io.File;

public class FileContentReaderTest {
    public static void main(String[] args) {
        FileContentReader contentReader = new ScannerContentReader();
        String content = contentReader.read(new File("files/file.txt"));
        String[] lines = content.split("\n");
        for (String c : lines) {
            if (CheckIfValid.isValidhone(c)) {
                System.out.println(c);
            }
        }
    }
}
