
package bamsapp;
import java.io.IOException;

public class Computations {
    public String idGenerate(String fileName) throws IOException{
        // totoalUser.txt Read Request
        FileRead fr = new FileRead();
        String idReadRequest[] = fr.fileCopy(fileName, 1);
        int newId = Integer.parseInt(idReadRequest[0]) + 1; 
        idReadRequest[0] = newId + "";
        // TotalUser.txt file Update Request
        FileWrite fw = new FileWrite();
        fw.fileWrite(fileName, idReadRequest);
        return newId + "";
    }
}
