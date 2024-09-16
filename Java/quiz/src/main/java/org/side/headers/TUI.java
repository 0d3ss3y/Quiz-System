package org.side.headers;

import java.io.IOException;

public interface TUI {
    static void displayHeader(){
        System.out.println("WELCOME TO A GENERAL KNOWLEDGE QUIZ");
        System.out.println();
    }

    static void displayRules(){
        System.out.println("""
GENERAL RULES:
[1] SELECT YOUR PREFERRED TOPIC.
[2] GET READY TO ANSWER QUESTIONS
[3] 10 QUESTIONS IN TOTAL
[4] AT THE END A SCORE WILL BE CALCULATED
          """);
    }

    static void clearing(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
