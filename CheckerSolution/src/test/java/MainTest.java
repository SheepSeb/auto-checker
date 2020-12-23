import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class MainTest {

    public static void runFile(String path,String name) throws IOException {
        String command1 = "javac " +path+name;
        String command2 = "java "+path+name;
        Runtime.getRuntime().exec(command1);
        Runtime.getRuntime().exec(command2);
    }

    public static void main(String[] args) throws IOException {

        String directory = System.getProperty("user.dir");
        directory = directory + "\\CheckerSoluion\\src\\test\\java\\";
        String output = "./a.out";

        ReadOutput readOutput = new ReadOutput(directory,output);
        readOutput.redirectOutput(readOutput.getOutput());
        testrun.main(args);
        System.out.println("new line");

    }

}
