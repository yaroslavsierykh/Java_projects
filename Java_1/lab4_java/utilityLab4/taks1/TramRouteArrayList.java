package utilityLab4.taks1;

import utilityLab3.task1.BaseTramRoute;
import utilityLab3.task1.StopV2;

import java.util.ArrayList;
import java.util.Arrays;

public class TramRouteArrayList extends BaseTramRoute {
    ArrayList<StopV2> stops = new ArrayList<>();

    public TramRouteArrayList(String routeNumber, ArrayList<StopV2> stops) {
        setRouteNumber(routeNumber);
        this.stops = stops;
    }


    @Override
    public void setStops(StopV2[] stops) {
        this.stops = new ArrayList<>(Arrays.asList(stops));
    }

    @Override
    public StopV2[] getStops() {
        return stops.toArray(new StopV2[0]);
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

        int min = stops.getFirst().getPassengers();

        for (int i = 1; i < stops.size(); i++) {
            if (stops.get(i).getPassengers() < min) {
                min = stops.get(i).getPassengers();
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
        StopV2 longestName = stops.getFirst();

        for (int i = 1; i < stops.size(); i++) {
            if (stops.get(i).getName().length() > longestName.getName().length()) {
                longestName = stops.get(i);
            }
        }

        return longestName;
    }

}
