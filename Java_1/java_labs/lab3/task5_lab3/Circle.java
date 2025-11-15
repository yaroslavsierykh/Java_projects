package lab3.task5_lab3;

public class Circle implements Comparable<Circle> {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle other) {
        return Integer.compare(this.radius, other.radius);
    }

    @Override
    public String toString() {
        return "Circle radius = " + radius;
    }
}