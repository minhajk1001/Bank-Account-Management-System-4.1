package bamsapp;

import java.io.IOException;
import java.util.Scanner;

public class BAMSapp {

    public static void main(String[] args) throws IOException {
        Scanner main_sc = new Scanner(System.in);
        Prompt prompt = new Prompt();
        prompt.mainPrompt(0);
        int decision = main_sc.nextInt();
        while (true) {
            if (decision < 1 || decision > 5) {
                prompt.mainPrompt(1);
                decision = main_sc.nextInt();
            } else {
                break;
            }
        }
        if (decision == 1) {
            Registration registration = new Registration();
        }
        if (decision == 2) {
            Deposite deposite = new Deposite();
        }
        if (decision == 3) {
            Withdraw withdraw = new Withdraw();
        }
        if (decision == 4) {
            Transfer transfer = new Transfer();
        }
        if (decision == 5) {
            ShowUserDetails showUserDetails = new ShowUserDetails();
        }
    }
}
