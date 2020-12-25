import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) throws IOException {
        //create Folder
        File folder = new File("Output");
        Output_files.createFolder(folder);

        //create n (given from keyboard) files
        Scanner console = new Scanner(System.in);
        System.out.print("Enter number of tests:");
        int testsNumber = console.nextInt();
        Output_files.createFiles(testsNumber);

        //Delete n files, and then the folder
        Output_files.deleteFolder(folder);


    }
}
