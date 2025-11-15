import java.util.Comparator;

public class StopNameComparator implements Comparator<Stop> {
    @Override
    public int compare(Stop s1, Stop s2) {
        return  s1.getName().compareToIgnoreCase(s2.getName());
    }
}
