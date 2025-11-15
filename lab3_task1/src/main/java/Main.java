import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування TramRouteArrayList та FileWorker ===");

        // 1) Підготовка даних
        ArrayList<Stop> stops = new ArrayList<>();
        stops.add(new Stop("Центральна", 45));
        stops.add(new Stop("Проспект Перемоги", 30));
        stops.add(new Stop("Площа Свободи", 60));
        stops.add(new Stop("Вокзал", 25));
        stops.add(new Stop("Садівнича вулиця", 25)); // ще одна мінімальна для тесту

        TramRouteArrayList route = new TramRouteArrayList("№12", stops);

        // 2) Тести логіки маршруту
        System.out.println("\n--- Логіка маршруту ---");
        System.out.println("Номер маршруту: " + route.getRouteNumber());

        int totalPassengers = route.calculateTotalPassengers();
        System.out.println("Загальна кількість пасажирів по маршруту: " + totalPassengers);

        Stop[] fewest = route.findStopsWithFewestPassengers();
        System.out.println("Зупинки з мінімальною кількістю пасажирів (" + (fewest.length) + "):");
        for (Stop s : fewest) {
            System.out.println("  - " + s);
        }

        Stop longestName = route.findStopWithLongestName();
        System.out.println("Зупинка з найдовшою назвою: " + longestName);

        System.out.println("\n--- Тест setStops/getStops ---");
        Stop[] newStopsArray = new Stop[] {
                new Stop("Нова1", 10),
                new Stop("Нова2ДовгаНазва", 5)
        };
        route.setStops(newStopsArray);
        Stop[] got = route.getStops();
        System.out.println("Після setStops(route) маршрутом є:");
        for (Stop s : got) {
            System.out.println("  * " + s);
        }

        route.setStops(stops.toArray(new Stop[0]));

        System.out.println("\n--- Запис маршрутів у файли (через TramRouteArrayList.writeRouteToFile) ---");
        route.writeRouteToFile(new ArrayList<>(Arrays.asList(route.getStops())), "route.txt", "txt");
        route.writeRouteToFile(new ArrayList<>(Arrays.asList(route.getStops())), "route.xml", "xml");
        route.writeRouteToFile(new ArrayList<>(Arrays.asList(route.getStops())), "route.json", "json");

        System.out.println("\n--- Тест FileWorker (Stream API, XML, JSON) ---");
        FileWorker fileWorker = new FileWorker();

        fileWorker.writeToTextFileByStream(new Stop("Тестова", 123), "single_stop.txt");
        System.out.println("Читання single_stop.txt:");
        fileWorker.readFromTextFileByStream("single_stop.txt");

        fileWorker.writeToFileXml(new Stop("XMLStop", 77), "single_stop.xml");
        System.out.println("Десеріалізація з single_stop.xml:");
        fileWorker.readFromFileXml("single_stop.xml");

        fileWorker.writeToFileJson(new Stop("JSONStop", 88), "single_stop.json");
        System.out.println("Десеріалізація з single_stop.json:");
        fileWorker.readFromFileJson("single_stop.json");

        System.out.println("\n--- Серіалізація масиву зупинок ---");
        Stop[] stopsArray = route.getStops();
        fileWorker.writeStopsToXmlFile(stopsArray, "stops_array.xml");
        fileWorker.writeStopsToJsonFile(stopsArray, "stops_array.json");

        System.out.println("Десеріалізація з stops_array.xml:");
        fileWorker.readStopsFromXmlFile("stops_array.xml");

        System.out.println("Десеріалізація з stops_array.json:");
        fileWorker.readStopsFromJsonFile("stops_array.json");

        System.out.println("\nУсі тести виконано. Перевірте створені файли: route.txt, route.xml, route.json, single_stop.*, stops_array.*");
    }
}
