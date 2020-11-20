import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class File {

    FileReader fileReader = new FileReader("text.txt");
    BufferedReader br = new BufferedReader(fileReader);

    public File() throws FileNotFoundException {
    }
}
