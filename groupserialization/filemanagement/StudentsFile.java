package groupserialization.filemanagement;

import lab3.task4.Group;
import lab3.task4.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsFile {

    public static void writeToFile(Group group, Path path) {
        try {
            // Формуємо список рядків для запису у файл
            List<String> lines = group.getStudents().stream()
                    .map(Student::toString)
                    .collect(Collectors.toList());

            lines.add(0, String.format("Середній бал групи: %.2f", group.getAverageGroupMark()));
            lines.add(0, "Кількість студентів: " + group.getStudentCount());
            lines.add(0, "Група: " + group.getGroupName());
            lines.add("");

            Files.write(path, lines);

            System.out.println("Записано у файл: " + path.getFileName());
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    public static void readFromFile(Path path) {
        try {
            if (!path.toString().endsWith(".txt") && !Files.exists(path)) {
                System.out.println("Неправильний формат файлу або він не існує");
                return;
            }

            List<String> list = Files.readAllLines(path);

            list.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Помилка при читанні з файлу: " + e.getMessage());
        }
    }
}
