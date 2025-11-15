package utilityLab5.task3;

import java.util.Comparator;

public class DigitSumComparatorAsc implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(sumOfDigits(a), sumOfDigits(b));
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

