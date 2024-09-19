package org.side;

import static org.side.functions.answersheet.sheet.*;
import static org.side.functions.reader.data_reader.*;
import static org.side.headers.TUI.*;

public class quiz {
    private static final int test_no = 10;

    public static void main(String[] args) {
        displayHeader();
        displayRules();
        String category = get_data();
        int score = question_sheet(category);
        clearing();
        displayTotal(score);
    }


}