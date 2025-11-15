import utilityLab3.task1.*;
import java.util.Arrays;

public class Lab3Task1 {
    public static void main(String[] args) {
        // Створення масиву зупинок
        StopV2[] stops = {
                new StopV2("Central Park", 120),
                new StopV2("Library", 80),
                new StopV2("Station", 80),
                new StopV2("Museum of Modern Art", 150),
                new StopV2("Zoo", 50)
        };

        // Створення маршруту
        TramRouteV2 route = new TramRouteV2("3A", stops);

        System.out.println("=== Початкові зупинки ===");
        StopPrinter.printStops(route.getStops());

        // Підрахунок загальної кількості пасажирів
        int totalPassengers = route.calculateTotalPassengers();
        System.out.println("\nЗагальна кількість пасажирів: " + totalPassengers);

        // Зупинки з найменшою кількістю пасажирів
        System.out.println("\n=== Зупинки з найменшою кількістю пасажирів ===");
        StopPrinter.printStops(route.findStopsWithFewestPassengers());

        // Зупинка з найдовшою назвою
        System.out.println("\n=== Зупинка з найдовшою назвою ===");
        StopPrinter.printStop(route.findStopWithLongestName());

        // Сортування за кількістю пасажирів (Comparable)
        Arrays.sort(stops);
        System.out.println("\n=== Сортування за кількістю пасажирів (Comparable) ===");
        StopPrinter.printStops(stops);

        // Сортування за назвою зупинки (Comparator)
        Arrays.sort(stops, new StopNameComparator());
        System.out.println("\n=== Сортування за назвою зупинки (Comparator) ===");
        StopPrinter.printStops(stops);

        // Тестування equals() та hashCode()
        StopV2 testStop1 = new StopV2("Library", 80);
        StopV2 testStop2 = new StopV2("Library", 80);
        System.out.println("\ntestStop1.equals(testStop2): " + testStop1.equals(testStop2));
        System.out.println("testStop1.hashCode(): " + testStop1.hashCode());
        System.out.println("testStop2.hashCode(): " + testStop2.hashCode());

        // Тестування toString()
        System.out.println("\n=== Приклад toString() ===");
        System.out.println(testStop1.toString());

        // Перевірка TramRouteWithLinkedList
        System.out.println("\n\n=== Перевірка TramRouteWithLinkedList ===");

        TramRouteWithLinkedList linkedRoute = new TramRouteWithLinkedList("5B");
        linkedRoute.addStop(new StopV2("Square", 70));
        linkedRoute.addStop(new StopV2("Airport", 90));
        linkedRoute.addStop(new StopV2("Zoo", 50));
        linkedRoute.addStop(new StopV2("University", 110));

        System.out.println("\nЗупинки маршруту (LinkedList):");
        StopPrinter.printStops(linkedRoute.getStops());

        System.out.println("\nЗагальна кількість пасажирів (LinkedList): " + linkedRoute.calculateTotalPassengers());

        System.out.println("\n=== Зупинки з найменшою кількістю пасажирів (LinkedList) ===");
        StopPrinter.printStops(linkedRoute.findStopsWithFewestPassengers());

        System.out.println("\n=== Зупинка з найдовшою назвою (LinkedList) ===");
        StopPrinter.printStop(linkedRoute.findStopWithLongestName());
    }
}
