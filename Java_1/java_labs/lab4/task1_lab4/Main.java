package lab4.task1_lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AbstractKiosk listKiosk = new ListKiosk("List Kiosk", "Main Street 1");

        AbstractKiosk sortedKiosk = new SortedSetKiosk("SortedSet Kiosk", "Main Street 1",
                Comparator.comparingInt(e -> ((SortedSetKiosk.HourEntry) e).getHour()));

        fillTestData(listKiosk);
        fillTestData(sortedKiosk);

        System.out.println("=== Дані з ListKiosk ===");
        printKioskData(listKiosk);

        System.out.println("\n=== Дані з SortedSetKiosk ===");
        printKioskData(sortedKiosk);

        System.out.println("\n=== Перевірка однаковості даних ===");
        if (Arrays.equals(listKiosk.getAllHourData(), sortedKiosk.getAllHourData())) {
            System.out.println("Дані збігаються!");
        } else {
            System.out.println(" Дані не збігаються.");
        }

        System.out.println("\n=== Сортування SortedSetKiosk за коментарями ===");
        SortedSetKiosk ssk = (SortedSetKiosk) sortedKiosk;
        for (var entry : ssk.getSortedByComment()) {
            System.out.println(entry.getHour() + ": " + entry.getData());
        }

        System.out.println("\n=== Сортування SortedSetKiosk за кількістю покупців (зменшення) ===");
        for (var entry : ssk.getSortedByCustomers()) {
            System.out.println(entry.getHour() + ": " + entry.getData());
        }
    }

    private static void fillTestData(AbstractKiosk kiosk) {
        kiosk.setHourData(8, new HourData(15, "Ранкові покупці"));
        kiosk.setHourData(12, new HourData(35, "Обідній наплив"));
        kiosk.setHourData(18, new HourData(22, "Після роботи"));
    }

    private static void printKioskData(AbstractKiosk kiosk) {
        HourData[] data = kiosk.getAllHourData();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + ": " + data[i]);
            }
        }
    }
}
