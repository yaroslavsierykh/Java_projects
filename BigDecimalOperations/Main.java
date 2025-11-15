package BigDecimalOperations;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BigDecimal> list = BigDecimalList.fillArrayOfDecimals(10);

        System.out.println("Початковий список:");
        System.out.println(list);

        ArrayList<BigDecimal> list1 = new ArrayList<>(list);
        BigDecimalList.selectionSort(list1);
        System.out.println("\nПісля selectionSort (за модулем, спадання):");
        System.out.println(list1);

        ArrayList<BigDecimal> list2 = new ArrayList<>(list);
        BigDecimalList.sortByComparator(list2);
        System.out.println("\nПісля sortByComparator (за модулем, спадання):");
        System.out.println(list2);

        ArrayList<BigDecimal> list3 = new ArrayList<>(list);
        BigDecimalList.sortByStreamInPlace(list3);
        System.out.println("\nПісля sortByStreamInPlace (за модулем, спадання):");
        System.out.println(list3);

        BigDecimal product1 = BigDecimalList.multiplyPositiveNumbers(list);
        System.out.println("\nДобуток додатних чисел (цикл): " + product1);

        BigDecimal product2 = BigDecimalList.multiplyPositiveNumbersByCollection(list);
        System.out.println("Добуток додатних чисел (колекція + forEach): " + product2);

        BigDecimal product3 = BigDecimalList.multiplyPositiveNumbersByStream(list);
        System.out.println("Добуток додатних чисел (Stream reduce): " + product3);
    }
}
