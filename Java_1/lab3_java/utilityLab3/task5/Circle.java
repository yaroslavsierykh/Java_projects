package utilityLab3.task5;

public class Circle implements Comparable<Circle> {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int compareTo(Circle other) {
        return Integer.compare(this.radius, other.radius);
    }

    @Override
    public String toString() {
        return  "Circle radius = " + radius;
    }
}
