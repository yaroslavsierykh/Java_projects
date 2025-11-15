package lab5.task1_lab5;

import lab4.task1_lab4.AbstractKiosk;
import lab4.task1_lab4.ArrayKiosk;
import lab4.task1_lab4.HourData;

/**
 * Main. Клас для демонстрації функцій збереження і зчитування кіосків у текстовий та бінарний файл.
 */
public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт кіоску з даними
        ArrayKiosk kiosk = new ArrayKiosk("Кіоск біля ринку", "вул. Центральна, 10");
        kiosk.setHourData(8, new HourData(15, "Ранкові покупці"));
        kiosk.setHourData(12, new HourData(25, "Година пік"));
        kiosk.setHourData(17, new HourData(10, "Спокійно"));

        // Текстовий файл
        String textFile = "kiosk_data.txt";
        KioskFileHandler.writeToTextFile(kiosk, textFile);
        AbstractKiosk loadedFromText = KioskFileHandler.readFromTextFile(textFile);

        System.out.println("Зчитано з текстового файлу:");
        printKioskData(loadedFromText);

        // Бінарний файл
        String binaryFile = "kiosk_data.dat";
        KioskFileHandler.writeToBinaryFile(kiosk, binaryFile);
        AbstractKiosk loadedFromBinary = KioskFileHandler.readFromBinaryFile(binaryFile);

        System.out.println("\nЗчитано з бінарного файлу:");
        printKioskData(loadedFromBinary);
    }

    /**
     * Допоміжний метод для друку даних з об'єкта кіоску.
     */
    public static void printKioskData(AbstractKiosk kiosk) {
        System.out.println("Назва: " + kiosk.getName());
        System.out.println("Адреса: " + kiosk.getAddress());

        HourData[] data = kiosk.getAllHourData();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println("Година " + i + ": " + data[i]);
            }
        }
    }
}

