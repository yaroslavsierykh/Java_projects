package BigDecimalOperations;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BigDecimalTest {
    @Test
    void testFillDecimal() {
        BigDecimal bigDecimal = BigDecimalList.fillBigDecimalByRandom();

        assertNotEquals(0, bigDecimal.toString().length());
    }

    @Test
    void testFillList() {
        ArrayList<BigDecimal> arrayList = BigDecimalList.fillArrayOfDecimals(10);

        assertEquals(10, arrayList.size());
    }

    @Test
    void testSelectionSort() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("5"));
        arrayList.add(new BigDecimal("-10"));
        arrayList.add(new BigDecimal("3"));

        BigDecimalList.selectionSort(arrayList);

        assertEquals(new BigDecimal("-10"), arrayList.get(0));
        assertEquals(new BigDecimal("5"), arrayList.get(1));
        assertEquals(new BigDecimal("3"), arrayList.get(2));
    }

    @Test
    void testSortByComparator() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("5"));
        arrayList.add(new BigDecimal("-10"));
        arrayList.add(new BigDecimal("3"));

        BigDecimalList.sortByComparator(arrayList);

        assertEquals(new BigDecimal("-10"), arrayList.get(0));
        assertEquals(new BigDecimal("5"), arrayList.get(1));
        assertEquals(new BigDecimal("3"), arrayList.get(2));
    }

    @Test
    void testSortByStream() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("5"));
        arrayList.add(new BigDecimal("-10"));
        arrayList.add(new BigDecimal("3"));

        BigDecimalList.sortByStreamInPlace(arrayList);

        assertEquals(new BigDecimal("-10"), arrayList.get(0));
        assertEquals(new BigDecimal("5"), arrayList.get(1));
        assertEquals(new BigDecimal("3"), arrayList.get(2));
    }

    @Test
    void testMultiplyPositiveNumbers() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("-3"));
        arrayList.add(new BigDecimal("10"));
        arrayList.add(new BigDecimal("20"));
        arrayList.add(new BigDecimal("-49"));

        assertEquals(new BigDecimal("200"), BigDecimalList.multiplyPositiveNumbers(arrayList));
    }

    @Test
    void testMultiplyPositiveByCollection() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("-3"));
        arrayList.add(new BigDecimal("10"));
        arrayList.add(new BigDecimal("20"));
        arrayList.add(new BigDecimal("-49"));

        assertEquals(new BigDecimal("200"), BigDecimalList.multiplyPositiveNumbersByCollection(arrayList));
    }

    @Test
    void testMultiplyPositiveNumbersByStream() {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        arrayList.add(new BigDecimal("-3"));
        arrayList.add(new BigDecimal("10"));
        arrayList.add(new BigDecimal("20"));
        arrayList.add(new BigDecimal("-49"));

        assertEquals(new BigDecimal("200"), BigDecimalList.multiplyPositiveNumbersByStream(arrayList));
    }
}
