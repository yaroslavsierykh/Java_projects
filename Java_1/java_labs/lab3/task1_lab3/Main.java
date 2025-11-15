package lab3.task1_lab3;

import java.util.Arrays;

/**
 * Демонстрація роботи з масивом та однозв'язним списком годин для кіоску.
 */
public class Main {
    public static void main(String[] args) {
        // Кіоск з масивом
        AbstractKiosk arrayKiosk = new ArrayKiosk("Точка 24/7", "вул. Героїв, 10");
        fillTestData(arrayKiosk);

        // Кіоск з однозв’язним списком
        AbstractKiosk linkedListKiosk = new LinkedListKiosk("Точка нічна", "вул. Лісова, 33");
        fillTestData(linkedListKiosk);

        System.out.println("=== Дані для Кіоску з масивом ===");
        testKiosk(arrayKiosk);

        System.out.println("\n=== Дані для Кіоску з однозв'язним списком ===");
        testKiosk(linkedListKiosk);
    }

    /**
     * Метод заповнює 5 тестових годин у кіоску.
     */
    public static void fillTestData(AbstractKiosk kiosk) {
        kiosk.setHourData(0, new HourData(5, "Тихо, майже нікого"));
        kiosk.setHourData(1, new HourData(2, "Майже безлюдно"));
        kiosk.setHourData(8, new HourData(20, "Ранковий наплив"));
        kiosk.setHourData(12, new HourData(30, "Година пік"));
        kiosk.setHourData(23, new HourData(3, "Пізні гості"));
    }

    /**
     * Метод виводить усі дані про кіоск, включаючи сортування та пошук.
     */
    public static void testKiosk(AbstractKiosk kiosk) {
        System.out.println("Кіоск: " + kiosk.getName() + ", " + kiosk.getAddress());
        System.out.println("Дані за всіма годинами:");

        HourData[] data = kiosk.getAllHourData();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.printf("Година %02d: %s\n", i, data[i]);
            }
        }

        System.out.println("\nЗагальна кількість покупців: " + KioskSearchHelper.getTotalCustomers(kiosk));
        System.out.println("Година з найменшою кількістю покупців: " + KioskSearchHelper.getHourWithLeastCustomers(kiosk));

        String keyword = "пік";
        String[] foundComments = KioskSearchHelper.getCommentsContaining(kiosk, keyword);
        System.out.println("\nКоментарі зі словом \"" + keyword + "\":");
        if (foundComments != null) {
            for (String c : foundComments) {
                System.out.println(" - " + c);
            }
        } else {
            System.out.println("Не знайдено.");
        }

        // Копія для сортування
        HourData[] toSort = Arrays.stream(data).filter(d -> d != null).toArray(HourData[]::new);

        System.out.println("\nСортування годин за зменшенням кількості покупців:");
        Arrays.sort(toSort);
        for (HourData d : toSort) {
            System.out.println(d);
        }

        System.out.println("\nСортування годин за алфавітом коментарів:");
        Arrays.sort(toSort, new HourDataCommentComparator());
        for (HourData d : toSort) {
            System.out.println(d);
        }
    }
}
