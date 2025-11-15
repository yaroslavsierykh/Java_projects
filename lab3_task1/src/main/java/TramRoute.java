public class TramRoute extends BaseTramRoute {
    private Stop[] stops;

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
}
