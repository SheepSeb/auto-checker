import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class File {
    private static final Path path = Paths.get("CheckerSolution\\src\\test\\file_testing\\input");
    private static int inputTestNumber = 1;

    public File(){
    }

    /**
     * Method to write in a file a huge ammount of data
     */
    public void writeInFile(String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(int i = 0 ; i< 2048 ; i++)
        {
            bufferedWriter.write("text\n");
        }
        bufferedWriter.close();
    }

    //function that transforms the input into a file using a relative path
    public java.io.File inputToFile() throws IOException {

        InputStream reader = System.in;

        java.io.File file = new java.io.File(path.toAbsolutePath()+"\\"+inputTestNumber+".in");
        inputTestNumber++;

        FileUtils.copyInputStreamToFile(reader, file);
        return file;

    }
}
