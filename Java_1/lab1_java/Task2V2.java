public class Task2V2 {
    public static void main(String[] args) {
        CalculatePowerBitwise();
    }
    public static void CalculatePowerBitwise() {
        for (int n = 0; n < 10; n++) {
            int powerResult = 1 << (n * 3);
            System.out.printf("8 to the power of %d = %d (binary: %s)%n", n, powerResult, Integer.toBinaryString(powerResult));
        }
    }
}
