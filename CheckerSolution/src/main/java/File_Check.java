import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

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
        Reader ax = new FileReader(a);
        Reader bx = new FileReader(b);
        return IOUtils.contentEqualsIgnoreEOL(ax, bx);
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
            {
                //System.out.println(fileOut + " --------------  " + fileCor);
                correct++;
            }
            //System.out.println(fileCor + "---------------" + fileOut);
            //System.out.println("Value " + sameContent(fileOut,fileCor) + " ------------ " + fileCor + "---------- " + fileOut);
        }
        return correct;
    }

}

