import utilityLab4.task2.ArrayUtils;
import java.util.Arrays;


public class Lab4Task2 {
    public static void main(String[] args) {
        // === Integer test ===
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        System.out.println("Original Integer array: " + Arrays.toString(intArray));

        ArrayUtils.swapGroups(intArray, 0, 3, 2);
        System.out.println("After swapGroups: " + Arrays.toString(intArray));

        ArrayUtils.swapNeighborPairs(intArray);
        System.out.println("After swapNeighborPairs: " + Arrays.toString(intArray));

        Integer[] intReplacement = {99, 88};
        ArrayUtils.replaceGroup(intArray, 2, intReplacement);
        System.out.println("After replaceGroup at index 2: " + Arrays.toString(intArray));


        // === Double test ===
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("\nOriginal Double array: " + Arrays.toString(doubleArray));

        ArrayUtils.swapGroups(doubleArray, 0, 2, 2);
        System.out.println("After swapGroups: " + Arrays.toString(doubleArray));

        ArrayUtils.swapNeighborPairs(doubleArray);
        System.out.println("After swapNeighborPairs: " + Arrays.toString(doubleArray));

        Double[] doubleReplacement = {7.7, 8.8, 9.9};
        ArrayUtils.replaceGroup(doubleArray, 1, doubleReplacement);
        System.out.println("After replaceGroup at index 1: " + Arrays.toString(doubleArray));


        // === String test ===
        String[] stringArray = {"apple", "banana", "cherry", "date", "fig"};
        System.out.println("\nOriginal String array: " + Arrays.toString(stringArray));

        ArrayUtils.swapGroups(stringArray, 1, 3, 2);
        System.out.println("After swapGroups: " + Arrays.toString(stringArray));

        ArrayUtils.swapNeighborPairs(stringArray);
        System.out.println("After swapNeighborPairs: " + Arrays.toString(stringArray));

        String[] stringReplacement = {"kiwi", "mango"};
        ArrayUtils.replaceGroup(stringArray, 2, stringReplacement);
        System.out.println("After replaceGroup at index 2: " + Arrays.toString(stringArray));
    }
}
