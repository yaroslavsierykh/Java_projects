package task1;


public class StopPrinter {
    public static void printStops(Stop[] stops) {
        for (Stop stop : stops) {
            System.out.println("Назва: " + stop.getName() + ", Пасажирів: " + stop.getPassengers());
        }
    }

    public static void printStop(Stop stop) {
        System.out.println("Назва: " + stop.getName() + ", Пасажирів: " + stop.getPassengers());
    }
}
