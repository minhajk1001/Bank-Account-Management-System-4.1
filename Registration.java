package bamsapp;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Registration {

    Scanner regi_sc = new Scanner(System.in);
    Prompt prompt = new Prompt();
    FileWrite fw = new FileWrite();
    Computations computations = new Computations();
    String registrationUserDetails[] = new String[18];

    public Registration() throws IOException {
        prompt.registrationPrompt(-1);
        for (int i = 2; i < 7; i++) {
            prompt.registrationPrompt(i);
            registrationUserDetails[i] = regi_sc.nextLine();
        }
        registrationUserDetails[0] = computations.idGenerate("totalUser.txt");
        prompt.registrationPrompt(0);
        System.out.println(registrationUserDetails[0]);
        prompt.registrationPrompt(1);
        registrationUserDetails[1] = regi_sc.nextLine();
        registrationUserDetails[7] = "100";
        for (int i = 8; i < 18; i++) {
            registrationUserDetails[i] = ThreadLocalRandom.current().nextInt(100000, 999999) + "";
        }
        //Request to create new user File
        fw.fileWrite(registrationUserDetails[0] + ".txt", registrationUserDetails);
    }
}
