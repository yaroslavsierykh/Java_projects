package dates;

/**
 * Enum {@code Month} represents all months of the year together with
 * the number of days in each month and the corresponding season.
 */
public enum Month {

    JANUARY(31, "Winter"),
    FEBRUARY(28, "Winter"),
    MARCH(31, "Spring"),
    APRIL(30, "Spring"),
    MAY(31, "Spring"),
    JUNE(30, "Summer"),
    JULY(31, "Summer"),
    AUGUST(31, "Summer"),
    SEPTEMBER(30, "Autumn"),
    OCTOBER(31, "Autumn"),
    NOVEMBER(30, "Autumn"),
    DECEMBER(31, "Winter");

    private final int days;
    private final String season;

    Month(int days, String season) {
        this.days = days;
        this.season = season;
    }

    public int getDays() {
        return days;
    }

    public String getSeason() {
        return season;
    }

    public Month getNext() {
        int nextIndex = (this.ordinal() + 1) % values().length;
        return values()[nextIndex];
    }

    public Month getPrevious() {
        int prevIndex = (this.ordinal() - 1 + values().length) % values().length;
        return values()[prevIndex];
    }

    @Override
    public String toString() {
        return this.name() + " (" + days + " days, " + season + ")";
    }

    public static void printAllMonths() {
        for (Month month : Month.values()) {
            System.out.println(month);
        }
    }
}
