package utility.task2;

public class Eratosthenes {
    public static void fillArrayTask2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void changeValues(int[] array) {
        for (int i = 2; i < array.length; i++) {
            if (array[i] != -1) {
                for (int j = i * 2; j < array.length; j += i) {
                    array[j] = -1;
                }
            }
        }
    }
}
