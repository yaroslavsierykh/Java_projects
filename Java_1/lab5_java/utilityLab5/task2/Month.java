package utilityLab5.task2;

public enum Month {
    СІЧЕНЬ(31, "Зима"),
    ЛЮТИЙ(28, "Зима"),
    БЕРЕЗЕНЬ(31, "Весна"),
    КВІТЕНЬ(30, "Весна"),
    ТРАВЕНЬ(31, "Весна"),
    ЧЕРВЕНЬ(30, "Літо"),
    ЛИПЕНЬ(31, "Літо"),
    СЕРПЕНЬ(31, "Літо"),
    ВЕРЕСЕНЬ(30, "Осінь"),
    ЖОВТЕНЬ(31, "Осінь"),
    ЛИСТОПАД(30, "Осінь"),
    ГРУДЕНЬ(31, "Зима");

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
        return this.name() + " (" + days + " днів, " + season + ")";
    }

    public static void printAllMonths() {
        for (Month month : Month.values()) {
            System.out.println(month);
        }
    }
}

