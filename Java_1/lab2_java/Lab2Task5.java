import utility.task5.Stop;
import utility.task5.TramRoute;

public class Lab2Task5 {
    public static void main(String[] args) {
        Stop stop1 = new Stop("Stop Name", 50);
        Stop stop2 = new Stop("Stop NameLonger", 30);
        Stop stop3 = new Stop("Stop NameTheLongest", 50);
        Stop stop4 = new Stop("Stop 4", 10);
        Stop stop5 = new Stop("Stop 5", 40);

        Stop[] stops = {stop1, stop2, stop3, stop4, stop5};

        TramRoute tramRoute = new TramRoute("Route 101", stops);

        System.out.println("Tram Route Number: " + tramRoute.getRouteNumber());

        System.out.println("All Stops:");
        for (Stop stop : tramRoute.getStops()) {
            System.out.println(stop.getName() + " - Passengers: " + stop.getPassengers());
        }

        Stop[] stopsWithFewestPassengers = tramRoute.findStopsWithFewestPassengers();
        System.out.println("\nStops with Fewest Passengers:");
        for (Stop stop : stopsWithFewestPassengers) {
            System.out.println(stop.getName() + " - Passengers: " + stop.getPassengers());
        }

        int totalPassengers = tramRoute.calculateTotalPassengers();
        System.out.println("\nTotal Passengers: " + totalPassengers);

        Stop stopWithLongestName = tramRoute.findStopWithLongestName();
        System.out.println("\nStop with Longest Name: " + stopWithLongestName.getName());
    }
}
