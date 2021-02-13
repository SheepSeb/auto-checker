

import java.io.IOException;
import java.io.File;
public class MainTest {
    public static void main(String[] args) throws IOException {
        File myFile = new File("C:\\Users\\naese\\Desktop\\Autochecker\\auto-checker-main\\auto-checker-main\\Ground\\ref");
        File secondFile = new File("C:\\Users\\naese\\Desktop\\Autochecker\\auto-checker-main\\auto-checker-main\\Ground\\out\\sursa4");

        File_Check file_check = new File_Check(myFile,secondFile,myFile.list().length);

        System.out.println(file_check.howManyAreCorrect());
    }
}
