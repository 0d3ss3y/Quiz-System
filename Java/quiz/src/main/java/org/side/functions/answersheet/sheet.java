package org.side.functions.answersheet;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.side.functions.reader.data_reader.*;

public class sheet {
    private static final Scanner scanner = new Scanner(System.in);

    public static int question_sheet(String category){
        int score= 0;
        List<Map<String,String>> ques_sheet = get_Question(category);

        for (Map<String,String> ques : ques_sheet) {
            String answer = ques.get("answer");
            String options = ques.get("options");
            System.out.println("Question: " + ques.get("question"));
            String attempt = displayOptions(options);
            boolean compareAns = answer.equals(attempt);

            if (compareAns)
                score++;

        }
        return score;
    }

    private static String displayOptions(String options) {
        char opt = 'A';
        String answer = "";

        options = options.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .trim();

        for (String option : options.split(",")) {
            System.out.println("["+opt+"] " +option.trim());
            opt++;
        }
        System.out.print("\nAnswer: ");
        answer = scanner.nextLine();
        return answer;
    }
}
