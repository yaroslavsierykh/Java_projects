import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StopTest {

    @Test
    void testConstructorAndGetters() {
        Stop stop = new Stop("Центральна", 50);
        assertEquals("Центральна", stop.getName());
        assertEquals(50, stop.getPassengers());
    }

    @Test
    void testSetters() {
        Stop stop = new Stop("Стара", 10);
        stop.setName("Нова");
        stop.setPassengers(30);

        assertEquals("Нова", stop.getName());
        assertEquals(30, stop.getPassengers());
    }

    @Test
    void testEqualsAndHashCode() {
        Stop s1 = new Stop("Центр", 40);
        Stop s2 = new Stop("Центр", 40);
        Stop s3 = new Stop("Вокзал", 20);

        assertEquals(s1, s2);
        assertNotEquals(s1, s3);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void testCompareTo() {
        Stop s1 = new Stop("A", 10);
        Stop s2 = new Stop("B", 20);
        assertTrue(s1.compareTo(s2) < 0);
    }

    @Test
    void testToString() {
        Stop stop = new Stop("Площа", 25);
        assertTrue(stop.toString().contains("Площа"));
        assertTrue(stop.toString().contains("25"));
    }
}
