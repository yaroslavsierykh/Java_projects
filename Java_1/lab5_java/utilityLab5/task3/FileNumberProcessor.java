package utilityLab5.task3;

import java.io.*;
import java.util.*;

public class FileNumberProcessor {

    public static void processFile(String inputFile, String outputAscFile, String outputDescFile) {
        List<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (num > 0) numbers.add(num);
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка при зчитуванні файлу: " + e.getMessage());
            return;
        }

        List<Integer> sortedAsc = new ArrayList<>(numbers);
        sortedAsc.sort(new DigitSumComparatorAsc());
        writeToFile(outputAscFile, sortedAsc);

        List<Integer> sortedDesc = new ArrayList<>(numbers);
        sortedDesc.sort(new DigitSumComparatorDesc());
        writeToFile(outputDescFile, sortedDesc);
    }

    private static void writeToFile(String filename, List<Integer> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Integer num : list) {
                writer.print(num + " ");
            }
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл " + filename + ": " + e.getMessage());
        }
    }
}
