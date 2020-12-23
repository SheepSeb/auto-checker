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
        directory = directory.replace("\\","/");

        String fileName = "testrun.java";

        PrintStream fileOut = new PrintStream("./out.txt");
        System.setOut(fileOut);

        System.out.println("Ceva");
        System.out.println(directory);

        runFile("C:\\Users\\naese\\Desktop\\Repos\\autochecker\\CheckerSolution\\src\\test\\java","\\testrun.java");

    }

}
