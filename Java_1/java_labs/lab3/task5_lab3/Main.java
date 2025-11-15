package lab3.task5_lab3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = {
                new Circle(10),
                new Circle(5),
                new Circle(15),
                new Circle(7),
                new Circle(12)
        };

        System.out.println("Before sorting:");
        for (Circle c : circles) {
            System.out.println(c);
        }

        Arrays.sort(circles);

        System.out.println("\nAfter sorting:");
        for (Circle c : circles) {
            System.out.println(c);
        }
    }
}
