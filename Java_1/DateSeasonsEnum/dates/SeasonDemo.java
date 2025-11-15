package dates;

/**
 * Demonstration class for working with {@link Month} enum.
 */
public class SeasonDemo {

    public static void main(String[] args) {

        Month current = Month.APRIL;

        System.out.println("Current month: " + current);
        System.out.println("Next month: " + current.getNext());
        System.out.println("Previous month: " + current.getPrevious());
        System.out.println("Season: " + current.getSeason());

        System.out.println("\nAll months:");
        Month.printAllMonths();
    }
}
