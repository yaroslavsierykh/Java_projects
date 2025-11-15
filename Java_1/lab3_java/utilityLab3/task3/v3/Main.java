package utilityLab3.task3.v3;

import utilityLab3.task3.v2.MathFunction;
import utilityLab3.task3.v2.Minimizer;

public class Main {
    public static void main(String[] argv) {
        MathFunction functionOne = new MathFunction() {
            @Override
            public double evaluate(double x) {
                return x * x + 3 * x + 2;
            }
        };

        MathFunction functionTwo = new MathFunction() {
            @Override
            public double evaluate(double x) {
                return Math.sin(x) + x / 2;
            }
        };

        double min1 = Minimizer.findMinimum(functionOne, 1, 10, 0.1);
        double min2 = Minimizer.findMinimum(functionTwo, 1, 10, 0.1);

        System.out.printf("Мінімум квадратної функції на [1, 10] : x = %f, f(x) = %f\n", min1, functionOne.evaluate(min1));
        System.out.printf("Мінімум квадратної функції на [1, 10] : x = %f, f(x) = %f", min2, functionOne.evaluate(min2));
    }
}
