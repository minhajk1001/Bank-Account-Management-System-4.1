package bamsapp;

import java.io.IOException;
import java.util.Scanner;

public class Deposite {

    Scanner depo_osc = new Scanner(System.in);
    Prompt prompt = new Prompt();
    FileRead fr = new FileRead();
    FileWrite fw = new FileWrite();

    public Deposite() throws IOException {
        prompt.depositePrompt(-1, "");
        prompt.depositePrompt(0, "");
        String id = depo_osc.nextLine();
        prompt.depositePrompt(1, "");
        int ammount = depo_osc.nextInt();
        //user.txt file read request
        String userInfo[] = fr.fileCopy(id + ".txt", 18);
        prompt.depositePrompt(2, id);
        int temp = Integer.parseInt(userInfo[7]) + ammount;
        userInfo[7] = temp + "";
        //user.txt file write/update request
        fw.fileWrite(id + ".txt", userInfo);
        prompt.depositePrompt(3, userInfo[7]);
        prompt.depositePrompt(4, "");
    }
}
