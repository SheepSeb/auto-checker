import java.io.File;

public class Input_files {

    /** Variabilele predefinite
     * Puteti modifica ce vreti de aici cat timp functioneaz
     * astea sunt doar niste indicatii*/

    private String dirName;
    private int numberFiles = 0;
    private String name;
    private File directoryInput;

    /** Constructor primeste ca parametru un string
     * ce este destinatia abosoluta a directorului/folder
     * creeaza un File (a nu se intelege ca deja este facut in sistem file-ul)*/

    public Input_files(String dirName) {
        this.dirName = dirName;
        directoryInput = new File(dirName);
    }
}
