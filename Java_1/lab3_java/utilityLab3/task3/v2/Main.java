package utilityLab3.task3.v2;

public class Main {
    public static void main(String[] args) {
        MathFunction f1 = new FunctionOne();
        MathFunction f2 = new FunctionTwo();

        double a = -10;
        double b = 10;
        double step = 0.1;

        double minF1 = Minimizer.findMinimum(f1, a, b, step);
        System.out.println("Minimum of FunctionOne at x = " + minF1 + ", value = " + f1.evaluate(minF1));

        double minF2 = Minimizer.findMinimum(f2, a, b, step);
        System.out.println("Minimum of FunctionTwo at x = " + minF2 + ", value = " + f2.evaluate(minF2));
    }
}
