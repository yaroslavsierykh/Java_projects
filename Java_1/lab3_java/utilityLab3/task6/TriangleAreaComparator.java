package utilityLab3.task6;

import java.util.Comparator;

public class TriangleAreaComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(o2.getArea(), o1.getArea()); //Навпаки, бо за зменшенням
    }
}
