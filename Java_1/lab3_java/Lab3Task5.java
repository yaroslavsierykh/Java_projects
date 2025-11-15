import utilityLab3.task5.Circle;
import utilityLab3.task5.Circles;

public class Lab3Task5 {
    public static void main(String[] argv) {
        Circles circles = new Circles();
        System.out.println("Before sort: ");
        circles.printCircles();

        circles.sortCircles();

        System.out.println("------------------");

        System.out.println("After sort: ");
        circles.printCircles();
    }
}
