package utilityLab5.task3;

import java.util.Comparator;

public class DigitSumComparatorDesc implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(sumOfDigits(b), sumOfDigits(a));
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
