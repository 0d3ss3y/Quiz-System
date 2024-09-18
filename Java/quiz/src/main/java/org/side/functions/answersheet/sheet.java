package org.side.functions.answersheet;

import java.util.List;
import java.util.Map;

import static org.side.functions.reader.data_reader.*;

public class sheet {

    public static int question_sheet(String category){
        List<Map<String,String>> ques_sheet = get_Question(category);

        for (Map<String,String> ques : ques_sheet) {
            String answer = ques.get("answer");
            String options = ques.get("options");
            System.out.println("Question: " + ques.get("question"));
            displayOptions(options);

        }
        return 0;
    }

    private static void displayOptions(String options) {
        char opt = 'A';
        options = options.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .trim();

        for (String option : options.split(",")) {
            System.out.println("["+opt+"] " +option.trim());
            opt++;
        }
        System.out.println();
    }
}
