package lab5.task3_lab5;

import java.io.*;
import java.util.*;

public class SortProcessor {

    /**
     * Статична функція, що зчитує числа з файлу, сортує та зберігає у два файли.
     */
    public static void processNumbers(String inputFile) {
        List<Integer> numbers = new ArrayList<>();

        // Зчитування чисел з файлу
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (number > 0) {
                        numbers.add(number);
                    }
                } else {
                    scanner.next(); // Пропустити нечислові токени
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не знайдено: " + inputFile);
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("У файлі не знайдено додатних чисел.");
            return;
        }

        // Сортування
        List<Integer> ascending = new ArrayList<>(numbers);
        List<Integer> descending = new ArrayList<>(numbers);

        ascending.sort(new SumDigitsAscendingComparator());
        descending.sort(new SumDigitsDescendingComparator());

        // Запис у файли
        writeToFile("sorted_ascending.txt", ascending);
        writeToFile("sorted_descending.txt", descending);

        System.out.println("Сортування завершено. Результати збережено у файли.");
    }

    private static void writeToFile(String fileName, List<Integer> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int n : list) {
                writer.write(n + " ");
            }
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + fileName);
        }
    }
}

