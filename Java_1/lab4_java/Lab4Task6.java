import utilityLab4.task6.IndexedArray;

import java.util.Arrays;
import java.util.Comparator;

public class Lab4Task6 {
    public static void main(String[] argv) {
        // Рядковий масив
        IndexedArray<String> array = new IndexedArray<>(-2, 2);
        array.set(-2, "C");
        array.set(-1, "A");
        array.set(0, "D");
        array.set(1, "B");
        array.set(2, "E");

        System.out.println("=== Рядки до сортування: ===");
        array.printArray();
        System.out.println();


        array.sort();
        System.out.println("=== Рядки після сортування: ===");
        array.printArray();
        System.out.println();


        IndexedArray<Integer> arr = new IndexedArray<>(2, 5);
        arr.set(2, 4);
        arr.set(3, 1);
        arr.set(4, 8);
        arr.set(5, 2);

        System.out.println("=== Числа до сортування: ===");
        arr.printArray();
        System.out.println();

        arr.sort();
        System.out.println("=== Числа після сортування (зростання): ===");
        arr.printArray();
        System.out.println();

        arr.sort(Comparator.reverseOrder());
        System.out.println("=== Числа після сортування (спадання): ===");
        arr.printArray();
    }
}
