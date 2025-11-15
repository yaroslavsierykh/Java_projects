public class Task2V1 {
    public static void main(String[] args) {
        CalculatePower();
    }
    public static void CalculatePower() {
        for (int n = 0; n < 10; n++) {
            int powerResult = (int) Math.pow(8, n);
            System.out.printf("8 to the power of %d = %d%n", n, powerResult);
        }
    }
}