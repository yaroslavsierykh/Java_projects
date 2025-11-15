package lab4.task3_lab4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(3, 0, -2, 5, -1, 0);
        List<Double> doubleList = Arrays.asList(-1.1, 0.0, 2.2, -3.3, 0.0);
        List<Long> longList = Arrays.asList(5L, -10L, 0L, 7L);

        testList(intList, "Integer");
        testList(doubleList, "Double");
        testList(longList, "Long");
    }

    private static <T extends Number> void testList(List<T> list, String typeName) {
        System.out.println("Тест для типу: " + typeName);
        System.out.println("Список: " + list);

        int zeroIndex = NumberListUtils.indexOfFirstZero(list);
        System.out.println("Індекс першого нульового елемента: " + zeroIndex);

        int negCount = NumberListUtils.countNegative(list);
        System.out.println("Кількість від’ємних чисел: " + negCount);

        T lastNeg = NumberListUtils.lastNegative(list);
        System.out.println("Останній від’ємний елемент: " + (lastNeg != null ? lastNeg : "відсутній"));

        System.out.println("------------------------");
    }
}
