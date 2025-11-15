package FileFilterSort.fileutils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Utility class for reading, filtering, sorting, and writing text files.
 */
public class ReaderWriter {

    /**
     * Reads a file, filters lines containing 'a', sorts them by length,
     * writes to output file, and prints both original and filtered content.
     *
     * @param inputPath path to the input file
     */
    public static void processFile(Path inputPath) {
        if (!Files.exists(inputPath) || !inputPath.toString().endsWith(".txt")) {
            System.out.println("File not found or invalid file format");
            return;
        }

        try (Stream<String> stream = Files.lines(inputPath)) {
            List<String> allLines = stream.toList();

            System.out.println("Reading from file: " + inputPath.toAbsolutePath());
            allLines.forEach(System.out::println);

            System.out.println("\n=====================================================\n");

            List<String> filteredList = allLines.stream()
                    .filter(line -> line.contains("a"))
                    .sorted(Comparator.comparing(String::length))
                    .toList();

            Path outputPath = Paths.get("output.txt");
            Files.write(outputPath, filteredList, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Successfully written to file: " + outputPath.toAbsolutePath());

            System.out.println("\n=====================================================\n");
            System.out.println("Reading filtered content from: " + outputPath.toAbsolutePath());
            List<String> listFromFile = Files.readAllLines(outputPath);
            listFromFile.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    /**
     * Main method to run the ReaderWriter demo.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to a text file: ");
        String input = scanner.nextLine().trim();
        processFile(Path.of(input));
        scanner.close();
    }
}
