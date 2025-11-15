package TramRouteUtil;

import java.io.Serializable;

/**
 * Represents a tram route containing a route number and a list of stops.
 */
public class TramRoute extends BaseTramRoute implements Serializable {

    private Stop[] stops;

    /**
     * Constructs a tram route with a route number and an array of stops.
     *
     * @param routeNumber the route identifier
     * @param stops       an array of stops on the route
     */
    public TramRoute(String routeNumber, Stop[] stops) {
        setRouteNumber(routeNumber);
        this.stops = stops;
    }

    @Override
    public Stop[] getStops() {
        return stops;
    }

    @Override
    public void setStops(Stop[] stops) {
        this.stops = stops;
    }

    @Override
    public int calculateTotalPassengers() {
        int total = 0;
        for (Stop stop : stops) {
            total += stop.getPassengers();
        }
        return total;
    }

    @Override
    public Stop[] findStopsWithFewestPassengers() {
        if (stops.length == 0) return new Stop[0];

        int min = stops[0].getPassengers();
        for (int i = 1; i < stops.length; i++) {
            if (stops[i].getPassengers() < min) {
                min = stops[i].getPassengers();
            }
        }

        int count = 0;
        for (Stop stop : stops) {
            if (stop.getPassengers() == min) count++;
        }

        Stop[] result = new Stop[count];
        int index = 0;
        for (Stop stop : stops) {
            if (stop.getPassengers() == min) {
                result[index++] = stop;
            }
        }

        return result;
    }

    @Override
    public Stop findStopWithLongestName() {
        Stop longest = stops[0];

        for (Stop stop : stops) {
            if (stop.getName().length() > longest.getName().length()) {
                longest = stop;
            }
        }
        return longest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramRoute{routeNumber='").append(getRouteNumber()).append("', stops=[");
        for (int i = 0; i < stops.length; i++) {
            sb.append(stops[i]);
            if (i < stops.length - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
