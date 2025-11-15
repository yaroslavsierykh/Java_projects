package bigint;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for BigIntegerWork.
 */
public class BigIntegerWorkTest {

    @Test
    void testPowerByPowFunction() {
        BigInteger number = new BigInteger("5");
        int exponent = 3;

        BigInteger result = BigIntegerWork.powerByPowFunction(number, exponent);

        assertEquals(new BigInteger("125"), result); // 5^3 = 125
    }

    @Test
    void testPowerByOwnFunction() {
        BigInteger number = new BigInteger("5");
        int exponent = 3;

        BigInteger result = BigIntegerWork.powerByOwnFunction(number, exponent);

        assertEquals(new BigInteger("125"), result); // 5^3 = 125
    }

    @Test
    void testConsistencyBetweenMethods() {
        BigInteger number = new BigInteger("7");
        int exponent = 4;

        BigInteger result1 = BigIntegerWork.powerByPowFunction(number, exponent);
        BigInteger result2 = BigIntegerWork.powerByOwnFunction(number, exponent);

        assertEquals(result1, result2);
    }

    @Test
    void checkSizeOfFill() {
        int size = 10;

        BigInteger randomNumber = BigIntegerWork.fillByRandomNumbers(size);

        assertEquals(size, randomNumber.toString().length());
    }
}
