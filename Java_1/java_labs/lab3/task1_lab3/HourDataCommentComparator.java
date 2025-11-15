package lab3.task1_lab3;

import java.util.Comparator;

/**
 * Компаратор для сортування за алфавітом коментарів.
 */
public class HourDataCommentComparator implements Comparator<HourData> {
    @Override
    public int compare(HourData a, HourData b) {
        return a.getComment().compareToIgnoreCase(b.getComment());
    }
}

