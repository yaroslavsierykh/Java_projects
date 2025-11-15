package TramRouteUtil;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a tram stop containing its name and passenger count.
 */
public class Stop implements Comparable<Stop>, Serializable {

    private String name;
    private int passengers;

    /**
     * Constructs a stop with the specified name and passenger count.
     *
     * @param name       the stop name
     * @param passengers the number of passengers at the stop
     */
    public Stop(String name, int passengers) {
        this.name = name;
        this.passengers = passengers;
    }

    /**
     * Returns the stop name.
     *
     * @return the stop name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of passengers at this stop.
     *
     * @return the passenger count
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets a new stop name.
     *
     * @param name the new stop name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets a new passenger count.
     *
     * @param passengers the new passenger count
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Stop)) return false;
        Stop stop = (Stop) obj;
        return passengers == stop.passengers &&
                Objects.equals(name, stop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passengers);
    }

    @Override
    public String toString() {
        return "Stop{name='" + name + "', passengers=" + passengers + "}";
    }

    /**
     * Compares two stops by passenger count.
     *
     * @param other another stop
     * @return comparison result
     */
    @Override
    public int compareTo(Stop other) {
        return Integer.compare(this.passengers, other.passengers);
    }
}
