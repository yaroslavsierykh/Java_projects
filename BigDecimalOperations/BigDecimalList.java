package BigDecimalOperations;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BigDecimalList {

    public static BigDecimal fillBigDecimalByRandom() {
        StringBuilder number = new StringBuilder();

        int size = (int) (Math.random() * 30 + 1);

        for (int i = 0; i < size; i++) {
            number.append((int)(Math.random() * 10));
        }

        if (size > 1 && Math.random() > 0.5) {
            int pointIndex = (int) (Math.random() * (size - 1)) + 1;
            number.insert(pointIndex, ".");
        }

        if (Math.random() > 0.5) {
            return new BigDecimal(number.toString());
        } else {
            return new BigDecimal("-" + number.toString());
        }
    }

    public static ArrayList<BigDecimal> fillArrayOfDecimals(int size) {
        ArrayList<BigDecimal> listOfDecimals= new ArrayList<>();

        for (int i = 0; i < size; i++) {
            listOfDecimals.add(fillBigDecimalByRandom());
        }

        return listOfDecimals;
    }

    public static void selectionSort(ArrayList<BigDecimal> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < arrayList.size(); j++) {
                BigDecimal currentAbs = arrayList.get(j).abs();
                BigDecimal maxAbs = arrayList.get(maxIndex).abs();

                if (currentAbs.compareTo(maxAbs) > 0) {
                    maxIndex = j;
                }
            }

            BigDecimal temp = arrayList.get(maxIndex);
            arrayList.set(maxIndex, arrayList.get(i));
            arrayList.set(i, temp);
        }
    }

    public static BigDecimal multiplyPositiveNumbers(ArrayList<BigDecimal> arrayList) {
        BigDecimal result = BigDecimal.ONE;
        boolean hasPositive = false;

        for (BigDecimal current : arrayList) {
            if (current.compareTo(BigDecimal.ZERO) > 0) {
                result = result.multiply(current);
                hasPositive = true;
            }
        }
        return hasPositive ? result : BigDecimal.ZERO;
    }

    public static void sortByComparator(ArrayList<BigDecimal> arrayList) {
        arrayList.sort(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal a, BigDecimal b) {
                return b.abs().compareTo(a.abs());
            }
        });
    }

    public static BigDecimal multiplyPositiveNumbersByCollection(ArrayList<BigDecimal> arrayList) {
        List<BigDecimal> positives = new ArrayList<>(arrayList);
        positives.removeIf(x -> x.compareTo(BigDecimal.ZERO) <= 0);

        if (positives.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal[] result = {BigDecimal.ONE};
        positives.forEach(x -> result[0] = result[0].multiply(x));
        return result[0];
    }

    public static void sortByStreamInPlace(ArrayList<BigDecimal> arrayList) {
        List<BigDecimal> sorted = arrayList.stream()
                .sorted((a, b) -> b.abs().compareTo(a.abs()))
                .toList();
        arrayList.clear();
        arrayList.addAll(sorted);
    }


    public static BigDecimal multiplyPositiveNumbersByStream(ArrayList<BigDecimal> arrayList) {
        return arrayList.stream()
                    .filter(x -> x.compareTo(BigDecimal.ZERO) > 0)
                    .reduce(BigDecimal::multiply)
                    .orElse(BigDecimal.ZERO);
    }

}