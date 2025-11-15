import java.util.Arrays;

import static utility.task1V2.ArraysWorkV2.*;

public class Lab2Task1V2 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        int[][] array = new int[rows][cols];

        for (int i = 0; i < array.length; i++) {
            fillArayV2(array, i);
        }

        System.out.println(Arrays.deepToString(array));

        int[] maxValues = findMaxValuesV2(array);
        String[] strArray = arrayStringFillV2(maxValues);

        System.out.println(Arrays.toString(strArray));

        Arrays.sort(strArray, (a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println(Arrays.toString(strArray));
;    }
}

