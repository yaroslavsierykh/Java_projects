package lab3.task6_lab3;

import java.util.Comparator;

class TriangleAreaComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        // Для сортування за спаданням площі мінус
        return Double.compare(t2.getArea(), t1.getArea());
    }
}
