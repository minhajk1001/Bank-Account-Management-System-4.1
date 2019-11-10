package bamsapp;

import java.io.IOException;
import java.util.Scanner;

public class Transfer {

    Scanner tran_sc = new Scanner(System.in);
    Prompt prompt = new Prompt();
    FileRead fr = new FileRead();
    FileWrite fw = new FileWrite();
    private int secret = -9 * 5 / 4 * 64 / 8 - 5;

    public Transfer() throws IOException {
        prompt.transferPrompt(-1);
        prompt.transferPrompt(0);
        String sendId = tran_sc.next();
        prompt.transferPrompt(1);
        String receivId = tran_sc.next();
        //user.txt read request
        String sendInfo[] = fr.fileCopy(sendId + ".txt", 18);
        String receivfo[] = fr.fileCopy(receivId + ".txt", 18);
        prompt.transferPrompt(2);
        int amount = tran_sc.nextInt();
        prompt.transferPrompt(5);
        int verificationCode = tran_sc.nextInt();
        boolean matched = false;
        for (int i = 8; i < 18; i++) {
            int code = Integer.parseInt(sendInfo[i]);
            if (verificationCode == code && verificationCode != secret) {
                matched = true;
                sendInfo[i] = secret + "";
                break;
            }
        }
        int sendTotalBalance = Integer.parseInt(sendInfo[7]);
        int receiveTotalBalance = Integer.parseInt(receivfo[7]);
        if (amount - 100 < sendTotalBalance) {
            sendTotalBalance -= amount;
            sendInfo[7] = sendTotalBalance + "";
            receiveTotalBalance += amount;
            receivfo[7] = receiveTotalBalance + "";
            prompt.printline();
            prompt.transferPrompt(sendId, sendInfo[7]);
            prompt.transferPrompt(receivId, receivfo[7]);
            prompt.transferPrompt(4);
        } else {
            prompt.transferPrompt(3);
        }
        //user.txt file write/update request
        fw.fileWrite(sendId + ".txt", sendInfo);
        fw.fileWrite(receivId + ".txt", receivfo);
    }
}
