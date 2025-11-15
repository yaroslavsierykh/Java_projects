package utilityLab3.task5;

import java.util.Arrays;

public class Circles {
    private Circle[] circles = new Circle[5];

    public Circles() {
        circles[0] = new Circle(10);
        circles[1] = new Circle(7);
        circles[2] = new Circle(14);
        circles[3] = new Circle(3);
        circles[4] = new Circle(20);
    }

    public void sortCircles() {
        Arrays.sort(circles);
    }

    public void printCircles() {
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
