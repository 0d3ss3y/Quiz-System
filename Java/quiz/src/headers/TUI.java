package headers;

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

    static void clearing(){}
}
