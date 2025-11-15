package lab3.task6_lab3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Triangle[] triangles = {
                new Triangle(3, 4, 5),
                new Triangle(5, 12, 13),
                new Triangle(6, 8, 10),
                new Triangle(7, 7, 7),
                new Triangle(2, 2, 3)
        };

        System.out.println("Before sorting:");
        for (Triangle t : triangles) {
            System.out.println(t);
        }

        Arrays.sort(triangles, new TriangleAreaComparator());

        System.out.println("\nAfter sorting by descending area:");
        for (Triangle t : triangles) {
            System.out.println(t);
        }
    }
}
