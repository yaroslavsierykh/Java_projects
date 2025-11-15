package DirectoryExplorer.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Utility class for printing directories and files.
 */
public class DirectoryList {

    /**
     * Recursively prints directories and files starting from the given folder.
     *
     * @param folder starting folder
     * @param level  indentation level for nested directories
     */
    public static void printDirectoriesRecursive(File folder, int level) {
        if (folder == null || !folder.exists()) {
            System.out.println("Directory not found");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            System.out.println(" ".repeat(level) + file.getName());
            if (file.isDirectory()) {
                printDirectoriesRecursive(file, level + 4);
            }
        }
    }

    /**
     * Prints all directories and files using java.nio.file API.
     *
     * @param path starting path
     */
    public static void printDirectoriesNio(Path path) {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println("This is not a valid directory");
            return;
        }

        try (Stream<Path> stream = Files.walk(path)) {
            stream.forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }

    /**
     * Main method to run the directory listing demo.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String pathInput = scanner.nextLine().trim();
        Path path = Path.of(pathInput);
        File folder = new File(pathInput);

        System.out.println("\nListing files using java.io.File (recursive):");
        printDirectoriesRecursive(folder, 0);

        System.out.println("=================================================");

        System.out.println("Listing files using java.nio.file:");
        printDirectoriesNio(path);

        scanner.close();
    }
}
