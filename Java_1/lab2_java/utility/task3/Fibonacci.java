package utility.task3;

public class Fibonacci {
    public static long[] arrayFibonacci = new long[92];
    private static int last = 1;

    static {
        arrayFibonacci[0] = 1;
        arrayFibonacci[1] = 1;
    }

    public static long fibonacci(int n) {
        if (n < 0 || n >= arrayFibonacci.length) {
            throw new IllegalArgumentException("n must be in range [0, 91]");
        }

        if (n > last) {
            for (int i = last + 1; i <= n; i++) {
                arrayFibonacci[i] = arrayFibonacci[i - 1] + arrayFibonacci[i - 2];
            }
            last = n;
        }
        return arrayFibonacci[n];
    }
}
