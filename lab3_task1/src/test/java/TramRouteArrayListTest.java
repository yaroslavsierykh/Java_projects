import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TramRouteArrayListTest {

    private TramRouteArrayList route;

    @BeforeEach
    void setup() {
        ArrayList<Stop> stops = new ArrayList<>();
        stops.add(new Stop("Центральна", 45));
        stops.add(new Stop("Проспект Перемоги", 30));
        stops.add(new Stop("Площа Свободи", 60));
        stops.add(new Stop("Вокзал", 25));

        route = new TramRouteArrayList("12", stops);
    }

    @Test
    void testCalculateTotalPassengers() {
        assertEquals(160, route.calculateTotalPassengers());
    }

    @Test
    void testFindStopsWithFewestPassengers() {
        Stop[] fewest = route.findStopsWithFewestPassengers();
        assertEquals(1, fewest.length);
        assertEquals("Вокзал", fewest[0].getName());
    }

    @Test
    void testFindStopWithLongestName() {
        Stop longest = route.findStopWithLongestName();
        assertEquals("Проспект Перемоги", longest.getName());
    }

    @Test
    void testSetAndGetStops() {
        Stop[] newStops = {
                new Stop("Олексіївка", 15),
                new Stop("Наукова", 40)
        };
        route.setStops(newStops);
        assertEquals(2, route.getStops().length);
    }
}
