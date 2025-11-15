package numberprocessing;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Demo class demonstrating how {@link FileNumberProcessor} processes
 * numbers from a file and sorts them based on digit sum.
 */
public class NumberProcessingDemo {
    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter("input.txt")) {
            writer.println("23 5 14 101 8 77 3");
        } catch (IOException e) {
            System.err.println("Failed to create input.txt: " + e.getMessage());
        }

        FileNumberProcessor.processFile(
                "input.txt",
                "sorted_asc.txt",
                "sorted_desc.txt"
        );

        System.out.println("Processing finished. Results written to sorted_asc.txt and sorted_desc.txt.");
    }
}
