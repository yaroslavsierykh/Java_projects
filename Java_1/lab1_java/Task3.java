import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give x value:");
        int x = scanner.nextInt();
        System.out.println("Give n value:");
        int n = scanner.nextInt();
        scanner.close();
        Calculate(x, n);
    }

    public static void Calculate(int x, int n) {
        double product = 1.0;
        boolean errorOccurred = false;

        outerLoop:
        for (int i = 1; i < n - 1; i++) {
            double sum = 0;
            
            for (int j = 0; j < n; j++) {
                if (i == j + x) {
                    System.out.println("Skipping i = " + i + " because i == j + x");
                    continue outerLoop;
                }
                if (j + x == 0) {
                    System.out.println("Error! Can't divide by zero at j = " + j);
                    errorOccurred = true;
                    break outerLoop;
                }
                sum += (double) i / (j + x);
            }
            product *= sum;
        }
        if (!errorOccurred) {
            System.out.printf("Final result: %.2f%n", product);
        }
        else {
            System.out.println("Program stopped!");
        }

    }
}
