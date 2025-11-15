import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        final int UPPER_LIMIT = 12;
        Scanner scanner = new Scanner(System.in);

        int start = readInt(scanner, "Введіть початкове значення (start): ");
        int end = readInt(scanner, "Введіть кінцеве значення (end), яке повинне бути більше за start: ");
        while (end <= start) {
            System.out.println("Кінцеве значення повинне бути більше за початкове.");
            end = readInt(scanner, "Введіть кінцеве значення (end): ");
        }

        double step = readDouble(scanner, "Введіть крок (step, > 0): ");
        while (step <= 0) {
            System.out.println("Крок повинен бути більшим за 0.");
            step = readDouble(scanner, "Введіть крок (step, > 0): ");
        }

        System.out.println("\nРезультати обчислення:");
        for (double x = start; x <= end; x += step) {
            double functionResult = FunctionCalculator.calculateValue(x, UPPER_LIMIT);
            System.out.printf("x = %.2f, y = %.2f%n", x, functionResult);
        }
    }

    /**
     * Метод для безпечного зчитування цілого числа з консолі.
     */
    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Це не ціле число.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Метод для безпечного зчитування числа типу double з консолі.
     */
    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Це не число.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static class FunctionCalculator {
        public static double calculateValue(double x, int upperLimit) {
            if (x < 4) {
                double totalSum = 0;
                for (int k = 1; k <= upperLimit; k++) {
                    totalSum += Math.pow(1 - x / 4, k);
                }
                return 3 * x + 6 + totalSum;
            } else {
                return 4 * Math.cos(x - 4) + 14;
            }
        }
    }
}
