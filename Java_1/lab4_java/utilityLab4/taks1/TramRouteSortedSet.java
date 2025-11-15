package utilityLab4.taks1;

import utilityLab3.task1.BaseTramRoute;
import utilityLab3.task1.StopV2;

import java.util.*;

public class TramRouteSortedSet extends BaseTramRoute {
    SortedSet<StopV2> stops = new TreeSet<>();

    public TramRouteSortedSet(String routeNumber,Comparator<StopV2> comparator) {
        setRouteNumber(routeNumber);
        this.stops = new TreeSet<>(comparator);
    }

    public TramRouteSortedSet(String routeNumber) {
        setRouteNumber(routeNumber);
        this.stops = new TreeSet<>();
    }

    @Override
    public StopV2[] getStops() {
        return stops.toArray(new StopV2[0]);
    }

    @Override
    public void setStops(StopV2[] stops) {
        this.stops.clear();
        this.stops.addAll(Arrays.asList(stops));
    }

    @Override
    public int calculateTotalPassengers() {
        int sum = 0;

        for (StopV2 stop : stops) {
            sum += stop.getPassengers();
        }
        return sum;
    }

    @Override
    public StopV2[] findStopsWithFewestPassengers() {
        if (stops.isEmpty()) {
            return new StopV2[0];
        }
        Iterator<StopV2> iterator = stops.iterator();
        StopV2 first = iterator.next();
        int min = first.getPassengers();

        for (StopV2 stop : stops) {
            if (stop.getPassengers() < min) {
                min = stop.getPassengers();
            }
        }


        ArrayList<StopV2> result = new ArrayList<>();
        for (StopV2 stop : stops) {
            if (stop.getPassengers() == min) {
                result.add(stop);
            }
        }
        return result.toArray(new StopV2[0]);
    }

    @Override
    public StopV2 findStopWithLongestName() {
        if (stops.isEmpty()) return null;

        Iterator<StopV2> iterator = stops.iterator();
        StopV2 longestName = iterator.next();

        while (iterator.hasNext()) {
            StopV2 current = iterator.next();
            if (current.getName().length() > longestName.getName().length()) {
                longestName = current;
            }
        }

        return longestName;
    }
}
