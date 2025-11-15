package utility.task1V2;

import java.util.Arrays;

public class ArraysWorkV2 {
    public static void fillArayV2(int[][] arr, int row) {
        Arrays.setAll(arr[row], j -> 5 + 2 * (int)(Math.random() * ((21 - 5) / 2 + 1)));
    }

    public static int[] findMaxValuesV2(int[][] arr) {
        int[] maxValue = new int[arr[0].length];
        Arrays.setAll(maxValue, j -> {
            int max = arr[0][j];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            return max;
        });
        return maxValue;
    }

    public static String[] arrayStringFillV2(int[] maxValues) {
        String[] strArray = new String[maxValues.length];
        Arrays.setAll(strArray, i -> "Y".repeat(maxValues[i]));
        return strArray;
    }
}
