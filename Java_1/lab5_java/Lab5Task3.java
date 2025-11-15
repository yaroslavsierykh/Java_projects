import utilityLab5.task3.FileNumberProcessor;

import java.io.IOException;
import java.io.PrintWriter;

public class Lab5Task3 {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("input.txt")) {
            writer.println("23 5 14 101 8 77 3");
        } catch (IOException e) {
            System.err.println("Не вдалося створити input.txt: " + e.getMessage());
        }
        FileNumberProcessor.processFile("input.txt", "sorted_asc.txt", "sorted_desc.txt");
        System.out.println("Обробка завершена. Результати записано у sorted_asc.txt та sorted_desc.txt.");
    }
}
