package lab2.task3_lab2;

/**
 * Клас для тестування обчислення чисел Фібоначчі з використанням кешування.
 */
public class Main {
    public static void main(String[] args) {
        int testLimit = 20;

        System.out.println("Перші " + testLimit + " чисел Фібоначчі:");
        for (int i = 0; i < testLimit; i++) {
            System.out.print(Fibonacci.fibonacci(i) + " ");
        }

        // Перевірка повторного виклику (має бути миттєвим завдяки кешу)
        System.out.println("\n\nПовторне звернення до числа Фібоначчі під індексом 15:");
        System.out.println("F(15) = " + Fibonacci.fibonacci(15));
    }
}

