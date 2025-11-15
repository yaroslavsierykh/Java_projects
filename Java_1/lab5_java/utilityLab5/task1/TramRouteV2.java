package utilityLab5.task1;

import TramRouteUtil.Stop;

import java.io.Serializable;

public class TramRouteV2 extends BaseTramRoute implements Serializable {
    private Stop[] stops;

    public TramRouteV2(String routeNumber, Stop[] stops) {
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
        int totalPassengers = 0;
        for (Stop stop : stops) {
            totalPassengers += stop.getPassengers();
        }
        return totalPassengers;
    }

    @Override
    public Stop[] findStopsWithFewestPassengers() {
        if (stops.length == 0) return new Stop[0];

        int minPassengers = stops[0].getPassengers();
        for (int i = 1; i < stops.length; i++) {
            if (stops[i].getPassengers() < minPassengers) {
                minPassengers = stops[i].getPassengers();
            }
        }

        int count = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i].getPassengers() == minPassengers) {
                count++;
            }
        }
        Stop[] result = new Stop[count];
        int index = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i].getPassengers() == minPassengers) {
                result[index++] = stops[i];
            }
        }

        return result;
    }

    @Override
    public Stop findStopWithLongestName() {
        Stop longestStop = stops[0];
        for (Stop stop : stops) {
            if (stop.getName().length() > longestStop.getName().length()) {
                longestStop = stop;
            }
        }
        return longestStop;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramRouteV2{routeNumber='").append(getRouteNumber()).append("', stops=[");
        for (int i = 0; i < stops.length; i++) {
            sb.append(stops[i].toString());
            if (i < stops.length - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }

}
