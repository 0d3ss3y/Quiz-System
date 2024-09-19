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
            System.out.println("\nQuestion: " + ques.get("question"));
            Boolean attempt = displayOptions(options, answer);

            if (attempt)
                score++;

        }
        return score;
    }

    private static Boolean displayOptions(String options, String correct_answer) {
        char selection = 'A';
        String answer = "";

        options = options.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .trim();

        String[] option = options.split(",");

        for (String opt : option) {
            System.out.println("["+ selection +"] " +opt.trim());
            selection++;
        }
        System.out.print("\nAnswer: ");
        answer = scanner.nextLine().trim().toUpperCase();

        int attemptIdx = answer.charAt(0) - 'A';

        if (attemptIdx >= 0 && attemptIdx < options.length()){
            String attempt = option[attemptIdx].trim();
            boolean correct = compareAnswers(correct_answer, attempt);

            if (correct)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static boolean compareAnswers(String answer, String attempt) {
        return answer.equals(attempt);
    }
}
