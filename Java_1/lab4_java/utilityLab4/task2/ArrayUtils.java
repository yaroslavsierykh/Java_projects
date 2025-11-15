package utilityLab4.task2;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> void swapGroups(T[] array, int start1, int start2, int length) {
        if (start1 + length > array.length || start2 + length > array.length) {
            throw new IllegalArgumentException("Invalid indices or length");
        }

        for (int i = 0; i < length; i++) {
            T temp = array[start1 + i];
            array[start1 + i] = array[start2 + i];
            array[start2 + i] = temp;
        }
    }

    public static <T> void swapNeighborPairs(T[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            T temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    public static <T> void replaceGroup(T[] array, int startIndex, T[] replacement) {
        if (startIndex < 0 || startIndex >= array.length) {
            throw new IndexOutOfBoundsException("Invalid startIndex: " + startIndex);
        }

        int lengthToCopy = Math.min(replacement.length, array.length - startIndex);

        for (int i = 0; i < lengthToCopy; i++) {
            array[startIndex + i] = replacement[i];
        }
    }
}

