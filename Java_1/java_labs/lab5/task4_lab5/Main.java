package lab5.task4_lab5;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Створення студентів
        Student s1 = new Student("Іван", "Іваненко", 101);
        Student s2 = new Student("Олена", "Петрівна", 102);
        Student s3 = new Student("Петро", "Сидоренко", 103);

        // Створення академічної групи
        AcademicGroup group = new AcademicGroup(new Student[]{s1, s2, s3});

        String fileName = "group.ser";

        // Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(group);
            System.out.println("Академічна група успішно серіалізована у файл " + fileName);
        } catch (IOException e) {
            System.err.println("Помилка при серіалізації: " + e.getMessage());
        }

        // Десеріалізація
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            AcademicGroup deserializedGroup = (AcademicGroup) ois.readObject();
            System.out.println("Академічна група після десеріалізації:");
            System.out.println(deserializedGroup);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при десеріалізації: " + e.getMessage());
        }
    }
}

