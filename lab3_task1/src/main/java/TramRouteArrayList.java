import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public class TramRouteArrayList extends BaseTramRoute {
    ArrayList<Stop> stops = new ArrayList<>();


    public TramRouteArrayList(String routeNumber, ArrayList<Stop> stops) {
        setRouteNumber(routeNumber);
        this.stops = stops;
    }


    @Override
    public void setStops(Stop[] stops) {
        this.stops = new ArrayList<>(Arrays.asList(stops));
    }

    @Override
    public Stop[] getStops() {
        return stops.toArray(new Stop[0]);
    }

    @Override
    public int calculateTotalPassengers() {
        int sum = 0;

        for (Stop stop : stops) {
            sum += stop.getPassengers();
        }

        return sum;
    }

    @Override
    public Stop[] findStopsWithFewestPassengers() {
        if (stops.isEmpty()) {
            return new Stop[0];
        }

        int min = stops.get(0).getPassengers(); // заміна getFirst()

        for (int i = 1; i < stops.size(); i++) {
            if (stops.get(i).getPassengers() < min) {
                min = stops.get(i).getPassengers();
            }
        }

        ArrayList<Stop> result = new ArrayList<>();
        for (Stop stop : stops) {
            if (stop.getPassengers() == min) {
                result.add(stop);
            }
        }
        return result.toArray(new Stop[0]);
    }

    @Override
    public Stop findStopWithLongestName() {
        if (stops.isEmpty()) {
            return null; // або кинути виняток за потреби
        }

        Stop longestName = stops.get(0); // заміна getFirst()

        for (int i = 1; i < stops.size(); i++) {
            if (stops.get(i).getName().length() > longestName.getName().length()) {
                longestName = stops.get(i);
            }
        }

        return longestName;
    }


    public void writeRouteToFile(ArrayList<Stop> stops, String fileName, String fileType) {
        FileWorker fileWorker = new FileWorker();

        switch (fileType) {
            case "txt" -> {
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName),
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                    for (Stop stop : stops) {
                        writer.write(stop.toString());
                        writer.newLine();
                    }
                    System.out.println("Маршрут записано у текстовий файл: " + fileName);
                } catch (IOException e) {
                    System.err.println("Помилка запису TXT: " + e.getMessage());
                }
            }

            case "xml" -> {
                Stop[] stopArray = stops.toArray(new Stop[0]);
                fileWorker.writeStopsToXmlFile(stopArray, fileName);
                System.out.println("Маршрут записано у XML-файл: " + fileName);
            }

            case "json" -> {
                Stop[] stopArray = stops.toArray(new Stop[0]);
                fileWorker.writeStopsToJsonFile(stopArray, fileName);
                System.out.println("Маршрут записано у JSON-файл: " + fileName);
            }

            default -> System.out.println("Невідомий тип файлу: " + fileType);
        }
    }



}
