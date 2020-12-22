

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {
    public static void main(String[] args) throws IOException {
        File myFile = new File();
        File secondFile = new File();

        //Doesn't go to the path gets IOException
        //myFile.writeInFile("src/test/file_testing/text_crt.txt");

        System.out.println(myFile.inputToFile());

    }
}
