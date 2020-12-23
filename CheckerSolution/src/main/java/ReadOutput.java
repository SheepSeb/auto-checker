import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class ReadOutput {
    private String pathToSource;
    private String pathToOutput;
    private File output;
    private File source;

    /**
     * Constructor init files si creaza file de output*/
    public ReadOutput(String pathToSource, String pathToOutput) throws IOException {
        this.pathToSource = pathToSource;
        this.pathToOutput = pathToOutput;
        output = new File(pathToOutput);
        source = new File(pathToSource);
        output.createNewFile();
    }

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    /***
     * De utilizat parte de task 03 run files*/

    public void redirectOutput(File output) throws FileNotFoundException {
        /**
         * Rulez sursa source primita si ii scot output-ul in fisierul output*/
        PrintStream fileOut = new PrintStream(output);
        System.setOut(fileOut);
    }

}
