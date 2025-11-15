package TramRouteUtil;

/**
 * Demonstrates the usage of FileWork for saving and loading tram routes and stops.
 */
public class Main {

    public static void main(String[] args) {

        Stop stop = new Stop("Central", 30);

        TramRoute route = new TramRoute("101", new Stop[]{
                new Stop("A", 10),
                new Stop("B", 5),
                new Stop("LongerNameStop", 8)
        });

        // ===== Binary files =====
        FileWorker.saveStopBinary("stop.dat", stop);
        Stop loadedStopBin = FileWorker.loadStopBinary("stop.dat");
        System.out.println("Stop from binary file: " + loadedStopBin);

        FileWorker.saveRouteBinary("route.dat", route);
        TramRoute loadedRouteBin = FileWorker.loadRouteBinary("route.dat");
        System.out.println("\nRoute from binary file: " + loadedRouteBin);

        // ===== Text files =====
        FileWorker.saveStopText("stop.txt", stop);
        Stop loadedStopTxt = FileWorker.loadStopText("stop.txt");
        System.out.println("\nStop from text file: " + loadedStopTxt);

        FileWorker.saveRouteText("route.txt", route);
        TramRoute loadedRouteTxt = FileWorker.loadRouteText("route.txt");
        System.out.println("\nRoute from text file: " + loadedRouteTxt);
    }
}
