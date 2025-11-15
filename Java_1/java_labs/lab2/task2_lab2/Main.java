package lab2.task2_lab2;

/**
 * Клас для перевірки алгоритму "решето Ератосфена".
 */
public class Main {
    public static void main(String[] args) {
        int size = 50;
        int[] numbers = new int[size + 1];

        Eratosthenes.fillArrayTask2(numbers);
        Eratosthenes.changeValues(numbers);

        System.out.println("Прості числа до " + size + ":");
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] != -1) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}

