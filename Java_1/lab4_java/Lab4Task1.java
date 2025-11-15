import utilityLab3.task1.StopV2;
import utilityLab3.task1.StopNameComparator;
import utilityLab4.taks1.TramRouteArrayList;
import utilityLab4.taks1.TramRouteSortedSet;

import java.util.ArrayList;

public class Lab4Task1 {
    public static void main(String[] args) {
        // Створення зупинок
        StopV2[] stops = {
                new StopV2("Central", 50),
                new StopV2("Park", 20),
                new StopV2("Zoo", 20),
                new StopV2("University", 100),
                new StopV2("Station", 35),
                new StopV2("Park", 20)
        };

        // ArrayList реалізація
        ArrayList<StopV2> stopList = new ArrayList<>();
        for (StopV2 s : stops) {
            stopList.add(s);
        }
        TramRouteArrayList arrayListRoute = new TramRouteArrayList("A1", stopList);

        // TreeSet без компаратора (по пасажирах)
        TramRouteSortedSet sortedSetRouteNatural = new TramRouteSortedSet("A1");
        sortedSetRouteNatural.setStops(stops);

        // TreeSet з компаратором за іменем
        TramRouteSortedSet sortedSetRouteByName = new TramRouteSortedSet("A1", new StopNameComparator());
        sortedSetRouteByName.setStops(stops);

        System.out.println("Total Passengers (ArrayList): " + arrayListRoute.calculateTotalPassengers());
        System.out.println("Total Passengers (SortedSet natural): " + sortedSetRouteNatural.calculateTotalPassengers());
        System.out.println("Total Passengers (SortedSet by name): " + sortedSetRouteByName.calculateTotalPassengers());
        System.out.println();

        System.out.println("Longest name (ArrayList): " + arrayListRoute.findStopWithLongestName());
        System.out.println("Longest name (SortedSet natural): " + sortedSetRouteNatural.findStopWithLongestName());
        System.out.println("Longest name (SortedSet by name): " + sortedSetRouteByName.findStopWithLongestName());
        System.out.println();

        System.out.println("Stops with fewest passengers (ArrayList):");
        for (StopV2 s : arrayListRoute.findStopsWithFewestPassengers()) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Stops with fewest passengers (SortedSet natural):");
        for (StopV2 s : sortedSetRouteNatural.findStopsWithFewestPassengers()) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Stops with fewest passengers (SortedSet by name):");
        for (StopV2 s : sortedSetRouteByName.findStopsWithFewestPassengers()) {
            System.out.println(s);
        }
    }
}
