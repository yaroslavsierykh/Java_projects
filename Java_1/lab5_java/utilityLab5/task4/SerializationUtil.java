package utilityLab5.task4;

import java.io.*;

public class SerializationUtil {
    public static void saveToFile(Object obj, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(obj);
            System.out.println("Об'єкт успішно серіалізовано у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка при серіалізації: " + e.getMessage());
        }
    }

    public static Object loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при десеріалізації: " + e.getMessage());
            return null;
        }
    }
}

