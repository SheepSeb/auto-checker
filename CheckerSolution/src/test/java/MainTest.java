import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        File myFile = new File("C:\\Users\\remus\\Desktop\\TestDir1");
        File secondFile = new File("C:\\Users\\remus\\Desktop\\TestDir2");

        File_Check file_check = new File_Check(myFile,secondFile,2);

        System.out.println(file_check.howManyAreCorrect());
    }
}
