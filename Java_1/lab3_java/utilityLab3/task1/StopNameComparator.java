package utilityLab3.task1;

import java.util.Comparator;

public class StopNameComparator implements Comparator<StopV2> {
    @Override
    public int compare(StopV2 s1, StopV2 s2) {
        return  s1.getName().compareToIgnoreCase(s2.getName());
    }
}
