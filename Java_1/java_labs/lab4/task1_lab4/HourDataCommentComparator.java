package lab4.task1_lab4;

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

