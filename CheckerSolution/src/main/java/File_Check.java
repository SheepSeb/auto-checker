import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class File_Check {

    /**
     * Variabilele predefinite
     * Puteti modifica ce vreti de aici cat timp functioneaz
     * astea sunt doar niste indicatii
     */

    private int numberFiles;
    private File dirOutput;
    private File dirCorrect;

    public File_Check(File a, File b, int nrFiles) {
        this.numberFiles = nrFiles;
        this.dirCorrect = b;
        this.dirOutput = a;
    }

    public static boolean sameContent(File a, File b) throws IOException {
        return FileUtils.contentEquals(a, b);
    }

    //functia iti spune cate din fisierele din directorul de output
    // au aceleasi continut cu cele din directorul cu corecte
    public int howManyAreCorrect() throws IOException {
        int correct = 0;
        String x = dirOutput.getAbsolutePath();
        String y = dirCorrect.getAbsolutePath();

        for (int i = 0; i < numberFiles; i++)
        {
            File fileOut = new File(x + "\\" + String.valueOf(i) + ".out");//modificat .out cu .txt
            File fileCor = new File(y + "\\" + String.valueOf(i) + ".out");//pt testare

            if (sameContent(fileOut,fileCor))
                correct++;
        }
        return correct;
    }

}

