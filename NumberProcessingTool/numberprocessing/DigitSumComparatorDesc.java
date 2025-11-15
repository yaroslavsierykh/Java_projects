package numberprocessing;

import java.util.Comparator;

/**
 * Comparator for sorting integers in descending order based on the sum of digits.
 */
public class DigitSumComparatorDesc implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(sumOfDigits(b), sumOfDigits(a));
    }

    /**
     * Calculates digit sum of a number.
     *
     * @param number integer value
     * @return sum of digits
     */
    private int sumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
