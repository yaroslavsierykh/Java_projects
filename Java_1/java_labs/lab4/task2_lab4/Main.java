package lab4.task2_lab4;

public class Main {
    public static void main(String[] args) {
        // Integer
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        System.out.println("Integer: початковий масив:");
        ArrayUtils.printArray(intArray);

        ArrayUtils.swapGroups(intArray, 0, 3, 2);
        System.out.println("Після обміну груп [0,1] і [3,4]:");
        ArrayUtils.printArray(intArray);

        ArrayUtils.swapAdjacentPairs(intArray);
        System.out.println("Після обміну пар сусідніх елементів:");
        ArrayUtils.printArray(intArray);

        Integer[] replacementInt = {9, 9};
        ArrayUtils.replaceGroup(intArray, 1, replacementInt);
        System.out.println("Після заміни з індексу 1 масивом {9, 9}:");
        ArrayUtils.printArray(intArray);

        System.out.println("\n------------------------\n");

        // Double
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        System.out.println("Double: початковий масив:");
        ArrayUtils.printArray(doubleArray);

        ArrayUtils.swapGroups(doubleArray, 0, 3, 2);
        System.out.println("Після обміну груп [0,1] і [3,4]:");
        ArrayUtils.printArray(doubleArray);

        ArrayUtils.swapAdjacentPairs(doubleArray);
        System.out.println("Після обміну пар сусідніх елементів:");
        ArrayUtils.printArray(doubleArray);

        Double[] replacementDouble = {8.8, 8.8};
        ArrayUtils.replaceGroup(doubleArray, 2, replacementDouble);
        System.out.println("Після заміни з індексу 2 масивом {8.8, 8.8}:");
        ArrayUtils.printArray(doubleArray);

        System.out.println("\n------------------------\n");

        // String
        String[] stringArray = {"one", "two", "three", "four", "five", "six"};
        System.out.println("String: початковий масив:");
        ArrayUtils.printArray(stringArray);

        ArrayUtils.swapGroups(stringArray, 0, 3, 2);
        System.out.println("Після обміну груп [0,1] і [3,4]:");
        ArrayUtils.printArray(stringArray);

        ArrayUtils.swapAdjacentPairs(stringArray);
        System.out.println("Після обміну пар сусідніх елементів:");
        ArrayUtils.printArray(stringArray);

        String[] replacementStr = {"A", "B"};
        ArrayUtils.replaceGroup(stringArray, 1, replacementStr);
        System.out.println("Після заміни з індексу 1 масивом {A, B}:");
        ArrayUtils.printArray(stringArray);
    }
}

