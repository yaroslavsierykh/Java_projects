import utilityLab4.task3.NumberListUtils;

import java.util.Arrays;
import java.util.List;

public class Lab4Task3 {
    public static void main(String[] args) {
        // Integer
        List<Integer> intList = Arrays.asList(3, -2, 0, 5, -8, 0, 4);
        testNumberList("Integer", intList);

        // Double
        List<Double> doubleList = Arrays.asList(1.1, -1.5, 0.0, 2.2, -3.3);
        testNumberList("Double", doubleList);

        // Float
        List<Float> floatList = Arrays.asList(0.0f, 0.5f, -0.7f, -2.0f, 3.3f);
        testNumberList("Float", floatList);
    }

    private static <T extends Number> void testNumberList(String typeName, List<T> list) {
        System.out.println("=== Тест для типу " + typeName + " ===");
        System.out.println("Список: " + list);

        int indexZero = NumberListUtils.indexOfFirstZero(list);
        System.out.println("Індекс першого нуля: " + indexZero);

        int negativeCount = NumberListUtils.quantityOfNegative(list);
        System.out.println("Кількість від’ємних елементів: " + negativeCount);

        Double lastNegative = NumberListUtils.lastNegative(list);
        if (lastNegative != null) {
            System.out.println("Останній від’ємний елемент: " + lastNegative);
        } else {
            System.out.println("Від’ємних елементів немає.");
        }

        System.out.println();
    }
}
