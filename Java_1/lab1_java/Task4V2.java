public class Task4V2 {
    public static void main(String[] args) {
        long[] array = new long[92];
        array[0] = 1;
        array[1] = 1;
        Fibonacci(array, 2);
        printArray(array);
    }
    public static void Fibonacci(long[] array, int index) {
        if (index == array.length) {
            return;
        }
        array[index] = array[index-1] + array[index - 2];
        Fibonacci(array, index + 1);
    }
    public static void printArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("The %d Fibonacci number is %d%n", i + 1, array[i]);
        }
    }
}
