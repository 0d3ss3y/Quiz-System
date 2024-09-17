package org.side;

import java.util.List;

import static org.side.functions.reader.data_reader.get_data;
import static org.side.headers.TUI.*;

public class quiz {
    public static void main(String[] args) {
        displayHeader();
        displayRules();
        List<String> questionSheet = get_data();
    }
}