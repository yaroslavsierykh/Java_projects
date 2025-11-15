package utilityLab5.task1;


import TramRouteUtil.FileWorker;
import TramRouteUtil.Stop;
import TramRouteUtil.TramRoute;

public class Main {
    public static void main(String[] args) {
        Stop stop = new Stop("Central", 30);
        TramRoute route = new TramRoute("101", new Stop[]{
                new Stop("A", 10),
                new Stop("B", 5),
                new Stop("LongerNameStop", 8)
        });

        //Бінарні файли
        FileWorker.saveStopBinary("stop.dat", stop);
        Stop loadedStopBin = FileWorker.loadStopBinary("stop.dat");
        System.out.println("Stop з бінарного файлу: " + loadedStopBin);

        FileWorker.saveRouteBinary("route.dat", route);
        TramRoute loadedRouteBin = FileWorker.loadRouteBinary("route.dat");
        System.out.println("\nRoute з бінарного файлу: " + loadedRouteBin);

        //Текстові файли
        FileWorker.saveStopText("stop.txt", stop);
        Stop loadedStopTxt = FileWorker.loadStopText("stop.txt");
        System.out.println("\nStop з текстового файлу: " + loadedStopTxt);

        FileWorker.saveRouteText("route.txt", route);
        TramRoute loadedRouteTxt = FileWorker.loadRouteText("route.txt");
        System.out.println("\nRoute з текстового файлу: " + loadedRouteTxt);
    }
}
