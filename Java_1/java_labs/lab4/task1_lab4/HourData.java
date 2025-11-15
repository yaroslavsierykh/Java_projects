package lab4.task1_lab4;

import java.io.Serializable;
import java.util.Objects;

public class HourData implements Comparable<HourData>, Serializable {
    private static final long serialVersionUID = 1L;
    private int customers;
    private String comment;

    public HourData(int customers, String comment) {
        this.customers = customers;
        this.comment = comment;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HourData)) return false;
        HourData other = (HourData) o;
        return customers == other.customers && Objects.equals(comment, other.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, comment);
    }

    @Override
    public int compareTo(HourData other) {
        return Integer.compare(other.customers, this.customers); // За зменшенням
    }

    @Override
    public String toString() {
        return customers + " покупців, коментар: \"" + comment + "\"";
    }
}