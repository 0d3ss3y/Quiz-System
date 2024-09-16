package org.side.functions.reader;

import java.io.IOException;
import java.nio.file.Files;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class data_reader {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> get_data() {
        List<String> sections = get_Sections();
        String selected_section = selected_section(sections);
        return get_Question(selected_section);
    }

    private static String selected_section(List<String> sections) {
        System.out.println();
        for (int i = 0; i < sections.size(); i++) {
            System.out.println("[");
            System.out.println(Integer.toString(i + 1));
            System.out.println("]");
            System.out.println(sections.get(i));
        }
        System.out.println("\nEnter your preferred section: ");
        return "";
    }

    private static List<String> get_Question(String category){
        List<String> questions = new ArrayList<>();

        try {
            String content = Files.readString(Paths.get("data/quiz_data.json"));
            JsonObject json = JsonParser.parseString(content).getAsJsonObject();

            if (json.has(category)) {
                ///JsonArray questionsArray = json.get(category).getAsJsonArray();
                JsonArray questionArray = json.getAsJsonArray(category);

                for (int i = 0; i < questionArray.size(); i++) {
                    JsonObject question = questionArray.get(i).getAsJsonObject();
                    String quesText = question.get("question").getAsString();
                    questions.add(quesText);
                }
            } else {
                System.out.println("Category not found: "+ category);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return questions;
    }


    private static List<String> get_Sections() {
        List<String> sections = new ArrayList<>();

        try {
            String content = Files.readString(Paths.get("data/quiz_data.json"));
            JsonObject data = JsonParser.parseString(content).getAsJsonObject();
            JsonObject section = data.getAsJsonObject("section");

            Set<String> sectionnames = section.keySet();
            sections.addAll(sectionnames);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sections;
    }
}
