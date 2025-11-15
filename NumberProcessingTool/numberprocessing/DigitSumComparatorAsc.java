package numberprocessing;

import java.util.Comparator;

/**
 * Comparator for sorting integers in ascending order based on the sum of digits.
 */
public class DigitSumComparatorAsc implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(sumOfDigits(a), sumOfDigits(b));
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
