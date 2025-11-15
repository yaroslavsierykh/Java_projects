package utility.task5;

import java.util.Arrays;

/**
 * Represents a tram route with multiple stops.
 */
public class TramRoute {
    private String routeNumber;
    private Stop[] stops;

    /**
     * Constructs a TramRoute object with the given route number and stops.
     *
     * @param routeNumber The route number of the tram.
     * @param stops The array of stops in the tram route.
     */
    public TramRoute(String routeNumber, Stop[] stops) {
        this.routeNumber = routeNumber;
        this.stops = stops;
    }

    /**
     * Gets the route number of the tram.
     *
     * @return The route number.
     */
    public String getRouteNumber() {
        return routeNumber;
    }

    /**
     * Gets the array of stops for the tram route.
     *
     * @return The array of stops.
     */
    public Stop[] getStops() {
        return stops;
    }

    /**
     * Sets the route number of the tram.
     *
     * @param routeNumber The route number to set.
     */
    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**
     * Sets the array of stops for the tram route.
     *
     * @param stops The array of stops to set.
     */
    public void setStops(Stop[] stops) {
        this.stops = stops;
    }

    /**
     * Calculates the total number of passengers across all stops in the tram route.
     *
     * @return The total number of passengers.
     */
    public int calculateTotalPassengers() {
        int totalPassengers = 0;
        for (Stop stop : stops) {
            totalPassengers += stop.getPassengers();
        }
        return totalPassengers;
    }

    /**
     * Finds the stops with the fewest number of passengers.
     *
     * @return An array of stops with the fewest passengers.
     */
    public Stop[] findStopsWithFewestPassengers() {
        int minPassengers = Arrays.stream(stops).mapToInt(Stop::getPassengers).min().orElse(Integer.MAX_VALUE);

        return Arrays.stream(stops)
                .filter(stop -> stop.getPassengers() == minPassengers)
                .toArray(Stop[]::new);
    }

    /**
     * Finds the stop with the longest name.
     *
     * @return The stop with the longest name.
     */
    public Stop findStopWithLongestName() {
        Stop longestStop = stops[0];
        for (Stop stop : stops) {
            if (stop.getName().length() > longestStop.getName().length()) {
                longestStop = stop;
            }
        }
        return longestStop;
    }
}
