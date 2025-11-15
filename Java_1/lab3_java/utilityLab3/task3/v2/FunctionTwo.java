package utilityLab3.task3.v2;

public class FunctionTwo implements MathFunction {
    @Override
    public double evaluate(double x) {
        return Math.sin(x) + x / 2;
    }
}
