import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TramRouteStream extends TramRouteArrayList {

    public TramRouteStream(String routeNumber, ArrayList<Stop> stops) {
        super(routeNumber, stops);
    }

    @Override
    public int calculateTotalPassengers() {
        return stops.stream()
                .mapToInt(Stop::getPassengers)
                .sum();
    }

    @Override
    public Stop[] findStopsWithFewestPassengers() {
        if (stops.isEmpty()) {
            return new Stop[0];
        }

        int min = stops.stream()
                .mapToInt(Stop::getPassengers)
                .min()
                .orElse(0);

        List<Stop> result = stops.stream()
                .filter(stopV2 -> stopV2.getPassengers() == min)
                .toList();

        return result.toArray(new Stop[0]);
    }

    @Override
    public Stop findStopWithLongestName() {
        return stops.stream()
                .max(Comparator.comparingInt(s -> s.getName().length()))
                .orElse(null);
    }

    public List<Stop> sortByPassengersAsc() {
        return stops.stream()
                .sorted(Comparator.comparingInt(Stop::getPassengers))
                .toList();
    }

    public List<Stop> sortByPassengersDesc() {
        return stops.stream()
                .sorted(Comparator.comparingInt(Stop::getPassengers).reversed())
                .toList();
    }

    public List<Stop> sortByNameLengthAsc() {
        return stops.stream()
                .sorted(Comparator.comparingInt((Stop s) -> s.getName().length()))
                .toList();
    }

    public List<Stop> sortByNameLengthDesc() {
        return stops.stream()
                .sorted(Comparator.comparingInt((Stop s) -> s.getName().length()).reversed())
                .toList();
    }

    public void printStops() {
        stops.forEach(s -> System.out.println("Назва: " + s.getName() + "\tКількість пасажирів: " + s.getPassengers()));
    }
}
