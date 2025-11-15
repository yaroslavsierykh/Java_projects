package utilityLab3.task3.v5;

import utilityLab3.task3.v2.MathFunction;
import utilityLab3.task3.v2.Minimizer;

public class Main {
    public static void main(String[] argv) {
        MathFunction f1 = MyFunctions::functionOne;
        MathFunction f2 = MyFunctions::functionTwo;

        double min1 = Minimizer.findMinimum(f1, 1, 10, 0.1);
        double min2 = Minimizer.findMinimum(f2, 1, 10, 0.1);

        System.out.printf("Мінімум квадратної функції на [1, 10] : x = %f, f(x) = %f\n", min1, f1.evaluate(min1));
        System.out.printf("Мінімум квадратної функції на [1, 10] : x = %f, f(x) = %f", min2, f1.evaluate(min2));
    }
}
