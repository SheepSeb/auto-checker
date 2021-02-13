import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Suspendable;

import java.io.*;
import java.util.ArrayList;

public class AutocheckerScript {

    protected static final String runJavac = "javac";
    protected static final String runJava = "java";
    protected static final String PATH = System.getProperty("user.dir") + "\\Ground\\";

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
    }

    public static void main(String[] args) throws Exception {
        File srcDir = new File(PATH +"src\\");
        File inDir = new File(PATH + "in\\");
        File refDir = new File(PATH + "ref\\");
        File outDir = new File(PATH + "out\\");
        outDir.mkdir();


        for(String sourceFile : srcDir.list())
        {
            int nrTest = 0;
            String nameSource = sourceFile.substring(0,sourceFile.indexOf("."));

            File outputFolder = new File(PATH + "out\\"+nameSource);
            outputFolder.mkdir();

            String pathOutput = PATH + "out\\"+nameSource;

            String pathSource = PATH +"src\\" +sourceFile;


            for(String testsFiles : inDir.list())
            {
                String pathInput = PATH +"in\\" +testsFiles;

                File test = new File(pathOutput+"\\"+nrTest+".out");
                test.createNewFile();

                runProcess(runJavac + " "+pathSource);

                ProcessBuilder processBuilder = new ProcessBuilder(runJava,pathSource);
                File in = new File(pathInput);
                File out = new File(pathOutput+"\\"+nrTest+".out");
                processBuilder.redirectInput(in);
                processBuilder.redirectOutput(out);

                Process pro = processBuilder.start();
                pro.waitFor();
                pro.destroy();
                nrTest++;
            }

        }

        File fList[] = srcDir.listFiles();

        for(int i = 0; i<fList.length;i++)
        {
            String resDel = fList[i].getName();
            if(resDel.endsWith(".class"))
            {
                boolean success = (new File(String.valueOf(fList[i])).delete());
            }
        }

        for(String dirs : outDir.list())
        {
            File output = new File(PATH + "out\\"+dirs);
            File_Check file_check = new File_Check(refDir,output,refDir.list().length);
            file_check.howManyAreCorrect();
            System.out.println(" Name " + output + " " + file_check.howManyAreCorrect());
        }

    }
}
