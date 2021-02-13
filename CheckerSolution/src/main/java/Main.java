import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    protected static final String runJavac = "javac -cp src";
    protected static final String runJava = "java -cp src";
    protected static final String argst = "C:\\Users\\naese\\Desktop\\TestingGround\\";

    private static void printLines(String cmd, InputStream ins) throws Exception
    {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null)
        {
            System.out.println(cmd + " " + line);
        }
    }

    private static void runProcess(String command) throws Exception
    {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        //System.out.println(command + " exitValue() " + pro.exitValue());
    }

    public static void main(String[] args) throws Exception {

        File srcDir = new File(argst + "src");
        int fileSrcCount = srcDir.list().length;

        int nrOutput = 1;

        for(String filename : srcDir.list())
        {
            File tests = new File(argst + "in");
            int fileTestCount = tests.list().length;

            //System.out.println(filename);

            runProcess(runJavac + " " + argst + "src\\" + filename);
            runProcess(runJava + " " + argst + "src\\" + filename);

        }
    }
}
