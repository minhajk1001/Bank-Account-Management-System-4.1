
package bamsapp;

import java.io.IOException;
import java.util.Scanner;

public class ShowUserDetails {
    Scanner Show_sc = new Scanner(System.in);
    FileRead fr = new FileRead();
    Prompt prompt = new Prompt();
    public ShowUserDetails() throws IOException{
        prompt.showUserDetailsPrompt(-1,"");
        prompt.showUserDetailsPrompt();
        String userId = Show_sc.nextLine();
        //user.txt file read request
        String userInfo[] = fr.fileCopy(userId + ".txt", 8);
        for(int i=0; i<8; i++){
            if(i == 1)
                continue;
            prompt.showUserDetailsPrompt(i,userInfo[i]);
        }
    }
}
