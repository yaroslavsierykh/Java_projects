package lab2.task1_lab2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;

        // Генерація двовимірного масиву
        int[][] matrix = IntMatrixGenerator.generateMatrix(rows, cols, 4, 33);
        System.out.println("Матриця чисел:");
        printMatrix(matrix);

        // Побудова масиву рядків
        String[] stringArray = StringArrayBuilder.buildStringArray(matrix, 'N');

        System.out.println("\nМасив рядків до сортування:");
        printArray(stringArray);

        // Сортування за довжиною: традиційний підхід
        String[] sortedTraditional = Arrays.copyOf(stringArray, stringArray.length);
        StringArraySorter.sortByLengthTraditional(sortedTraditional);

        System.out.println("\nСортований масив (традиційно):");
        printArray(sortedTraditional);

        // Сортування за довжиною: через Arrays.sort + лямбда (без stream)
        String[] sortedArrays = Arrays.copyOf(stringArray, stringArray.length);
        StringArraySorter.sortByLengthWithArrays(sortedArrays);

        System.out.println("\nСортований масив (через Arrays.sort):");
        printArray(sortedArrays);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int n : row) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    private static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
}
