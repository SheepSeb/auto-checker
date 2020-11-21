import java.io.*;

public class File {

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
}
