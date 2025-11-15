package lab5.task3_lab5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input_numbers.txt";

        // Створення тестового файлу з числами
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("123 45 7 89 12 55 33 101 999");
            System.out.println("Тестовий файл '" + inputFile + "' створено.");
        } catch (IOException e) {
            System.err.println("Помилка створення тестового файлу: " + e.getMessage());
            return;
        }

        // Виклик функції сортування
        SortProcessor.processNumbers(inputFile);
    }
}


