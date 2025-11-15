package lab4.task4_lab4;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть речення:");
        String sentence = scanner.nextLine();

        String[] words = sentence.toLowerCase().split("[\\s\\p{Punct}]+");

        SortedSet<String> uniqueWords = new TreeSet<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        System.out.println("Унікальні слова в алфавітному порядку:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        scanner.close();
    }
}

