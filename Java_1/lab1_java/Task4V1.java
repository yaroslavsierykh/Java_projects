public class Task4V1 {
    public static void main(String[] args) {
        long[] array = new long[92];
        array[0] = 1;
        array[1] = 1;
        Fibonacci(array);
        printArray(array);
    }
    public static void Fibonacci(long[] array) {
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
    }
    public static void printArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("The %d Fibonacci number is %d%n", i + 1, array[i]);
        }
    }
}
