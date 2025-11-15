package utilityLab3.task3.v2;

public class FunctionOne implements MathFunction {
    @Override
    public double evaluate(double x) {
        return x * x + 3 * x + 2;
    }
}
