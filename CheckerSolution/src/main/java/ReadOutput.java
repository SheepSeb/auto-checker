import java.io.File;
import java.io.IOException;

public class ReadOutput {
    private String pathToSource;
    private String pathToOutput;
    private File output;
    private File source;

    public ReadOutput(String pathToSource, String pathToOutput) throws IOException {
        this.pathToSource = pathToSource;
        this.pathToOutput = pathToOutput;
        output = new File(pathToOutput);
        source = new File(pathToSource);
        output.createNewFile();
    }
}
