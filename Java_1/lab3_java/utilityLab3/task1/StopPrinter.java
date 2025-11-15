package utilityLab3.task1;

public class StopPrinter {
    public static void printStops(StopV2[] stops) {
        for (StopV2 stop : stops) {
            System.out.println("Назва: " + stop.getName() + ", Пасажирів: " + stop.getPassengers());
        }
    }

    public static void printStop(StopV2 stop) {
        System.out.println("Назва: " + stop.getName() + ", Пасажирів: " + stop.getPassengers());
    }
}
