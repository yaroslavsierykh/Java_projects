package numberprocessing;

import java.io.*;
import java.util.*;

/**
 * Utility class for reading numbers from a file and sorting them
 * based on digit sum using ascending and descending comparators.
 */
public class FileNumberProcessor {

    /**
     * Reads numbers from input file, filters positives, sorts them,
     * and writes results to two output files.
     *
     * @param inputFile      file with numbers
     * @param outputAscFile  file for ascending result
     * @param outputDescFile file for descending result
     */
    public static void processFile(String inputFile, String outputAscFile, String outputDescFile) {

        List<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (num > 0) {
                        numbers.add(num);
                    }
                } else {
                    scanner.next();
                }
            }

        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
            return;
        }

        List<Integer> sortedAsc = new ArrayList<>(numbers);
        sortedAsc.sort(new DigitSumComparatorAsc());
        writeToFile(outputAscFile, sortedAsc);

        List<Integer> sortedDesc = new ArrayList<>(numbers);
        sortedDesc.sort(new DigitSumComparatorDesc());
        writeToFile(outputDescFile, sortedDesc);
    }

    /**
     * Writes a list of integers to a file.
     *
     * @param filename output file name
     * @param list     integers to write
     */
    private static void writeToFile(String filename, List<Integer> list) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (Integer num : list) {
                writer.print(num + " ");
            }

        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }
}
