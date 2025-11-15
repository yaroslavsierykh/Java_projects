package TramRouteUtil;

import java.io.Serializable;

/**
 * Abstract base class representing a tram route.
 * Provides common information about a route and abstract methods for stops processing.
 */
public abstract class BaseTramRoute implements Serializable {

    private String routeNumber;

    /**
     * Returns the route number.
     *
     * @return the route number
     */
    public String getRouteNumber() {
        return routeNumber;
    }

    /**
     * Sets the route number.
     *
     * @param routeNumber the new route number
     */
    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**
     * Returns the array of stops belonging to the route.
     *
     * @return an array of stops
     */
    public abstract Stop[] getStops();

    /**
     * Sets the array of stops for the route.
     *
     * @param stops a new array of stops
     */
    public abstract void setStops(Stop[] stops);

    /**
     * Calculates the total number of passengers across all stops.
     *
     * @return the total passenger count
     */
    public abstract int calculateTotalPassengers();

    /**
     * Finds all stops with the smallest number of passengers.
     *
     * @return an array of stops with the minimum passenger count
     */
    public abstract Stop[] findStopsWithFewestPassengers();

    /**
     * Finds the stop with the longest name.
     *
     * @return the stop with the longest name
     */
    public abstract Stop findStopWithLongestName();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BaseTramRoute that = (BaseTramRoute) obj;
        return routeNumber != null && routeNumber.equals(that.routeNumber);
    }

    @Override
    public int hashCode() {
        return routeNumber != null ? routeNumber.hashCode() : 0;
    }
}
