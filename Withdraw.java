package bamsapp;

import java.io.IOException;
import java.util.Scanner;

public class Withdraw {

    Scanner with_osc = new Scanner(System.in);
    Prompt prompt = new Prompt();
    FileRead fr = new FileRead();
    FileWrite fw = new FileWrite();
    private int secret = -9 * 5 / 4 * 64 / 8 - 5;

    public Withdraw() throws IOException {
        prompt.withdrawPrompt(-1, "");
        prompt.withdrawPrompt(0, "");
        String id = with_osc.nextLine();
        prompt.withdrawPrompt(1, "");
        int ammount = with_osc.nextInt();
        //user.txt file read request
        String userInfo[] = fr.fileCopy(id + ".txt", 18);
        prompt.withdrawPrompt(2, id);
        prompt.withdrawPrompt(3, id);
        int verificationCode = with_osc.nextInt();
        boolean matched = false;
        for (int i = 8; i < 18; i++) {
            int code = Integer.parseInt(userInfo[i]);
            if (verificationCode == code && verificationCode != secret) {
                matched = true;
                userInfo[i] = secret + "";
                break;
            }
        }
        if (matched) {
            int balance = Integer.parseInt(userInfo[7]);
            if (ammount - 100 < balance) {
                balance -= ammount;
                userInfo[7] = balance + "";
                prompt.withdrawPrompt(4, userInfo[7]);
                prompt.withdrawPrompt(6, "");
            } else {
                prompt.withdrawPrompt(7, "");
            }
        } else {
            prompt.withdrawPrompt(5, "");
        }
        //user.txt file write/update request
        fw.fileWrite(id + ".txt", userInfo);
    }
}
