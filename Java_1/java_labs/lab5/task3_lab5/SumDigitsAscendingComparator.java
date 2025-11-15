package lab5.task3_lab5;

import java.util.Comparator;

public class SumDigitsAscendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(sumDigits(a), sumDigits(b));
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

