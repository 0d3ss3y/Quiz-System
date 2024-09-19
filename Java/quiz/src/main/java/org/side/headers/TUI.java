package org.side.headers;

import java.io.IOException;

public interface TUI {
    static void displayHeader() {
        System.out.println("================================");
        System.out.println("       Welcome to the Quiz!");
        System.out.println("================================");
    }

    static void displayTotal(int score) {
        System.out.println("================================");
        System.out.println("        Quiz Completed!");
        System.out.println("================================");
        System.out.println("Your total score is: " + score + " out of "+ test_no +".");
        System.out.println("================================");
    }

    static void displayRules() {
        System.out.println("\nRules of the Quiz:");
        System.out.println("1. Each question has four options (A, B, C, D).");
        System.out.println("2. Only enter A, B, C, or D as your answer.");
        System.out.println("3. You will get 1 point for each correct answer.");
        System.out.println("4. No negative points for wrong answers.\n");
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
