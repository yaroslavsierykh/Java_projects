package utilityLab5.task1;

import TramRouteUtil.Stop;
import TramRouteUtil.TramRoute;

import java.io.*;

public class FileWork {
    public static void saveStopBinary(String filename, Stop stop) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(stop);
        } catch (IOException e) {
            System.err.println("Помилка при записі зупинки у бінарний файл: " + e.getMessage());
        }
    }

    public static Stop loadStopBinary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Stop) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при читанні зупинки з бінарного файлу: " + e.getMessage());
            return null;
        }
    }

    public static void saveRouteBinary(String filename, TramRoute route) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(route);
        } catch (IOException e) {
            System.err.println("Помилка при записі маршруту у бінарний файл: " + e.getMessage());
        }
    }

    public static TramRoute loadRouteBinary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (TramRoute) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при читанні маршруту з бінарного файлу: " + e.getMessage());
            return null;
        }
    }



    public static void saveStopText(String filename, Stop stop) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(stop.getName());
            writer.println(stop.getPassengers());
        } catch (IOException e) {
            System.err.println("Помилка при записі зупинки у текстовий файл: " + e.getMessage());
        }
    }

    public static Stop loadStopText(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String name = reader.readLine();
            int passengers = Integer.parseInt(reader.readLine());
            return new Stop(name, passengers);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка при читанні зупинки з текстового файлу: " + e.getMessage());
            return null;
        }
    }

    public static void saveRouteText(String filename, TramRoute route) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(route.getRouteNumber());
            for (Stop stop : route.getStops()) {
                writer.println(stop.getName() + ";" + stop.getPassengers());
            }
        } catch (IOException e) {
            System.err.println("Помилка при записі маршруту у текстовий файл: " + e.getMessage());
        }
    }

    public static TramRoute loadRouteText(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String routeNumber = reader.readLine();

            java.util.List<Stop> stopsList = new java.util.ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String name = parts[0];
                    int passengers = Integer.parseInt(parts[1]);
                    stopsList.add(new Stop(name, passengers));
                }
            }

            Stop[] stopsArray = new Stop[stopsList.size()];
            stopsArray = stopsList.toArray(stopsArray);

            return new TramRoute(routeNumber, stopsArray);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка при читанні маршруту з текстового файлу: " + e.getMessage());
            return null;
        }
    }

}
