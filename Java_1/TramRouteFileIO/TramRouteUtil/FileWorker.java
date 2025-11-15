package TramRouteUtil;

import java.io.*;

/**
 * Utility class for saving and loading tram stops and routes
 * using binary and text file formats.
 */
public class FileWorker {

    // ========================= BINARY =========================

    /**
     * Saves a Stop object to a binary file.
     *
     * @param filename the file to save to
     * @param stop     the stop to save
     */
    public static void saveStopBinary(String filename, Stop stop) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(stop);
        } catch (IOException e) {
            System.err.println("Error writing stop to binary file: " + e.getMessage());
        }
    }

    /**
     * Loads a Stop object from a binary file.
     *
     * @param filename the file to load from
     * @return the loaded Stop, or null if an error occurs
     */
    public static Stop loadStopBinary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Stop) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading stop from binary file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Saves a TramRoute object to a binary file.
     *
     * @param filename the file to save to
     * @param route    the route to save
     */
    public static void saveRouteBinary(String filename, TramRoute route) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(route);
        } catch (IOException e) {
            System.err.println("Error writing route to binary file: " + e.getMessage());
        }
    }

    /**
     * Loads a TramRoute from a binary file.
     *
     * @param filename the file to load from
     * @return the loaded route, or null on error
     */
    public static TramRoute loadRouteBinary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (TramRoute) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading route from binary file: " + e.getMessage());
            return null;
        }
    }

    // ========================= TEXT =========================

    /**
     * Saves a Stop object to a text file.
     *
     * @param filename the file to save to
     * @param stop     the stop to save
     */
    public static void saveStopText(String filename, Stop stop) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(stop.getName());
            writer.println(stop.getPassengers());
        } catch (IOException e) {
            System.err.println("Error writing stop to text file: " + e.getMessage());
        }
    }

    /**
     * Loads a Stop object from a text file.
     *
     * @param filename the file to load from
     * @return the loaded Stop, or null on error
     */
    public static Stop loadStopText(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String name = reader.readLine();
            int passengers = Integer.parseInt(reader.readLine());
            return new Stop(name, passengers);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading stop from text file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Saves a TramRoute object to a text file.
     *
     * @param filename the file to save to
     * @param route    the route to save
     */
    public static void saveRouteText(String filename, TramRoute route) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(route.getRouteNumber());
            for (Stop stop : route.getStops()) {
                writer.println(stop.getName() + ";" + stop.getPassengers());
            }
        } catch (IOException e) {
            System.err.println("Error writing route to text file: " + e.getMessage());
        }
    }

    /**
     * Loads a TramRoute from a text file.
     *
     * @param filename the file to load from
     * @return the loaded TramRoute, or null on error
     */
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

            Stop[] stopsArray = stopsList.toArray(new Stop[0]);
            return new TramRoute(routeNumber, stopsArray);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading route from text file: " + e.getMessage());
            return null;
        }
    }
}
