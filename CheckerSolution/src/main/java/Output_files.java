import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Output_files {

        static void createFolder(File folder) {
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("Folder has been created");
            } else {
                System.out.println("Folder already exists");
            }
        }

        static void createFiles(int testsNumber) {
            for (int testCount = 1; testCount <= testsNumber; testCount++) {
                File file = new File("Output/" + testCount + "_test.out");
                try {
                    PrintWriter output = new PrintWriter(file);
                    output.close();
                    System.out.println("am creat");
                } catch (IOException createFolderOutputEx) {
                    System.out.printf("ERROR: %s/n", createFolderOutputEx);
                }
            }

        }

        static void deleteFolder(File folder) {
            //Delete every file in the folder
            for (File subFile : folder.listFiles()) {
                if (subFile.isFile()) {
                    System.out.println("Am ce sa sterg");
                    if (subFile.delete()) {
                        System.out.println("Deleted the file: " + subFile.getName());
                    } else {
                        System.out.println("Failed to delete the file.");
                    }
                }
            }
            //If the folder is empty, delete it
            if (folder.isDirectory()) {
                if (folder.delete()) {
                    System.out.println("Deleted the folder: " + folder.getName());
                } else {
                    System.out.println("Failed to delete the folder.");
                }
            }
        }
    }

