package utility.task5;

/**
 * Represents a stop in the tram route with a name and a number of passengers.
 */
public class Stop {
    private String name;
    private int passengers;

    /**
     * Constructs a Stop object with the given name and number of passengers.
     *
     * @param name The name of the stop.
     * @param passengers The number of passengers at the stop.
     */
    public Stop(String name, int passengers) {
        this.name = name;
        this.passengers = passengers;
    }

    /**
     * Gets the name of the stop.
     *
     * @return The name of the stop.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of passengers at the stop.
     *
     * @return The number of passengers.
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the name of the stop.
     *
     * @param name The name to set for the stop.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the number of passengers at the stop.
     *
     * @param passengers The number of passengers to set.
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
