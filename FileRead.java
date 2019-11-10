package bamsapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
    * Takes fileName
    * Takes Return Array length
    * Read a fileName.txt file
    * Return all fleName.txt properties in an array
 */
public class FileRead {

    private static String fileLocation = "E:\\Minhaj\\java\\BAMSapp";

    public String[] fileCopy(String fileName, int numberOfFileProperties) throws IOException {
        //basic setup
        String arrayReference[] = new String[numberOfFileProperties];
        File file = new File(fileLocation + "\\" + fileName);
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        // Bring fileName.txt file into array
        Scanner file_sc = new Scanner(file);
        for (int i = 0; i < arrayReference.length; i++) {
            arrayReference[i] = file_sc.nextLine();
        }
        fw.close();
        pw.close();
        return arrayReference;
    }
}
