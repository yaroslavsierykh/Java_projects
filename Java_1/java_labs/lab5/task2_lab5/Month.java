package lab5.task2_lab5;

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
        int nextOrdinal = (this.ordinal() + 1) % Month.values().length;
        return Month.values()[nextOrdinal];
    }

    public Month getPrevious() {
        int prevOrdinal = (this.ordinal() - 1 + Month.values().length) % Month.values().length;
        return Month.values()[prevOrdinal];
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public static void printAllMonths() {
        for (Month m : Month.values()) {
            System.out.printf("%-10s | Днів: %-2d | Сезон: %s%n",
                    m.toString(), m.getDays(), m.getSeason());
        }
    }
}

