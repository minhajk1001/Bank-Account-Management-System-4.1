package bamsapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

    private static String fileLocation = "E:\\Minhaj\\java\\BAMSapp";

    public static void fileWrite(String fileName, String arrayCode[]) throws IOException {
        File file = new File(fileLocation + "\\" + fileName);
        FileWriter fw = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < arrayCode.length; i++) {
            fw.write(arrayCode[i]);
            pw.println();
        }
        fw.close();
        pw.close();
    }
}
