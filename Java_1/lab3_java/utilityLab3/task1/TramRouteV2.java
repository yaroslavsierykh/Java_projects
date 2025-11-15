package utilityLab3.task1;

import java.util.Arrays;

public class TramRouteV2 extends BaseTramRoute {
    private StopV2[] stops;

    public TramRouteV2(String routeNumber, StopV2[] stops) {
        setRouteNumber(routeNumber);
        this.stops = stops;
    }

    @Override
    public StopV2[] getStops() {
        return stops;
    }

    @Override
    public void setStops(StopV2[] stops) {
        this.stops = stops;
    }

    @Override
    public int calculateTotalPassengers() {
        int totalPassengers = 0;
        for (StopV2 stop : stops) {
            totalPassengers += stop.getPassengers();
        }
        return totalPassengers;
    }

    @Override
    public StopV2[] findStopsWithFewestPassengers() {
        if (stops.length == 0) return new StopV2[0];

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
        StopV2[] result = new StopV2[count];
        int index = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i].getPassengers() == minPassengers) {
                result[index++] = stops[i];
            }
        }

        return result;
    }

    @Override
    public StopV2 findStopWithLongestName() {
        StopV2 longestStop = stops[0];
        for (StopV2 stop : stops) {
            if (stop.getName().length() > longestStop.getName().length()) {
                longestStop = stop;
            }
        }
        return longestStop;
    }
}
