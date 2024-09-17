package org.side.functions.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.nio.file.Paths;
import java.util.*;

public class data_reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> get_data() {
        List<String> sections = get_Sections();

        if (sections.isEmpty()) {
            System.out.println("No data found");
            return Collections.emptyList();
        }

        String selected_section = selected_section(sections);

        if (selected_section != null)
            return get_Question(selected_section);
        return Collections.emptyList();
    }

    private static String selected_section(List<String> sections) {
        while (true) {
            try {
                System.out.println("\nAvailable sections:");
                for (int i = 0; i < sections.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + sections.get(i));
                }

                System.out.println("\nEnter your preferred section (number): ");
                if (scanner.hasNextInt()) {
                    int selection = scanner.nextInt();
                    scanner.nextLine();

                    if (selection >= 1 && selection <= sections.size()) {
                        return sections.get(selection - 1);
                    } else {
                        System.out.println("Invalid selection. Please choose a number between 1 and " + sections.size() + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static List<String> get_Question(String category){
        List<String> questions = new ArrayList<>();

        try (InputStream inputStream = data_reader.class.getClassLoader().getResourceAsStream("quiz_data.json")){

            if (inputStream == null) {
                System.out.println("No data found");
                return Collections.emptyList();
            }

            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject json = JsonParser.parseString(content).getAsJsonObject();
            JsonObject sections = json.getAsJsonObject("sections");

            if (json.has(category)) {
                JsonArray questionArray = sections.getAsJsonArray(category);

                for (int i = 0; i < questionArray.size(); i++) {
                    JsonObject question = questionArray.get(i).getAsJsonObject();
                    String quesText = question.get("question").getAsString();
                    questions.add(quesText);
                }
            } else {
                System.out.println("Category not found: " + category);
            }

        }catch (JsonSyntaxException e){
            System.out.println("Error parsing JSON");
        }catch (IOException e){
            System.out.println("System error while processing data");
            throw new RuntimeException(e);
        }
        return questions;
    }

    private static List<String> get_Sections() {
        List<String> sections = new ArrayList<>();

        try (InputStream inputStream = data_reader.class.getClassLoader().getResourceAsStream("quiz_data.json")) {
            if (inputStream == null) {
                System.out.println("Data file not found in resources.");
                return Collections.emptyList();
            }

            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject data = JsonParser.parseString(content).getAsJsonObject();
            JsonObject section = data.getAsJsonObject("sections");

            Set<String> sectionnames = section.keySet();
            sections.addAll(sectionnames);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            throw new RuntimeException(e);
        }

        return sections;
    }
}