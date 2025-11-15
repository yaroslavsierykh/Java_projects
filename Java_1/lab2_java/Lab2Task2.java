import static utility.task2.Eratosthenes.*;

public class Lab2Task2 {
    public static void main(String[] args) {
        int[] array = new int[300];
        fillArrayTask2(array);

        changeValues(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                System.out.println(array[i]);
            }
        }
    }
}
