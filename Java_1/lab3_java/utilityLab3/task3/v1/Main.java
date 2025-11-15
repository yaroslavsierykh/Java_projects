package utilityLab3.task3.v1;

public class Main {
    public static void main(String[] args) {
        FunctionOne f1 = new FunctionOne(-10, 10, 0.1);
        System.out.println("Мінімум FunctionOne на [-10,10]: x = " + f1.findMinimum());

        FunctionTwo f2 = new FunctionTwo(-10, 10, 0.1);
        System.out.println("Мінімум FunctionTwo на [-10,10]: x = " + f2.findMinimum());
    }
}
