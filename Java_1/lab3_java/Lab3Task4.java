import utilityLab3.task4.AbstractArrayOfPoints;
import utilityLab3.task4.ArrayOfPoints1D;
import utilityLab3.task4.ArrayOfPoints2D;

public class Lab3Task4 {
    public static void main(String[] argv) {
        AbstractArrayOfPoints array1 = new ArrayOfPoints2D();
        System.out.println("===Тестування 2D-масиву===");
        array1.test();

        AbstractArrayOfPoints array2 = new ArrayOfPoints1D();
        System.out.println("===Тестування 1D-масиву===");
        array2.test();
    }
}
