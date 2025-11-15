package utilityLab3.task3.v2;

public class Minimizer {
    public static double findMinimum(MathFunction function, double a, double b, double step) {
        double minX = a;
        double minY = function.evaluate(a);

        for (double x = a; x <= b; x += step) {
            double y = function.evaluate(x);

            if (y < minY) {
                minY = y;
                minX = x;
            }
        }
        return minX;
     }
}
