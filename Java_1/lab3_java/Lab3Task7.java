import utilityLab3.task7.*;

public class Lab3Task7 {
    public static void main(String[] args) {
        testIntegration("sin(x)", new SinFunction(), 0, Math.PI, 2.0, new double[]{0.1, 0.01, 0.001, 0.0001});

        double expExact = Math.exp(Math.PI) - 1;
        testIntegration("exp(x)", new ExpFunction(), 0, Math.PI, expExact, new double[]{0.5, 0.1, 0.01, 0.001});
    }

    private static void testIntegration(String name, Integrable function, double a, double b, double exactValue, double[] steps) {
        System.out.printf("%nІнтегруємо %s від %.2f до %.2f (точне значення ≈ %.8f)%n", name, a, b, exactValue);
        System.out.println("Крок\t\tПрямокутники\t\tПохибка\t\tТрапеції\t\tПохибка");

        for (double step : steps) {
            double rectResult = function.integral(a, b, step);
            double trapResult = new TrapezoidalIntegrator(function).integral(a, b, step);

            System.out.printf(
                    "%.4f\t\t%.8f\t\t%.8f\t\t%.8f\t\t%.8f%n",
                    step,
                    rectResult, Math.abs(rectResult - exactValue),
                    trapResult, Math.abs(trapResult - exactValue)
            );
        }
    }
}
