package bigint;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Provides methods for generating large random numbers and performing exponentiation.
 */
public class BigIntegerWork {

    /**
     * Generates a random BigInteger of specified length.
     *
     * @param size number of digits
     * @return generated BigInteger
     */
    public static BigInteger fillByRandomNumbers(int size) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < size; i++) {
            number.append((int) (Math.random() * 10));
        }
        return new BigInteger(number.toString());
    }

    /**
     * Raises a BigInteger to the given exponent using BigInteger.pow().
     *
     * @param bigInteger the base number
     * @param exponent   the exponent
     * @return result of exponentiation
     */
    public static BigInteger powerByPowFunction(BigInteger bigInteger, int exponent) {
        return bigInteger.pow(exponent);
    }

    /**
     * Raises a BigInteger to the given exponent using a manual multiplication loop.
     *
     * @param bigInteger the base number
     * @param exponent   the exponent
     * @return result of exponentiation
     */
    public static BigInteger powerByOwnFunction(BigInteger bigInteger, int exponent) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(bigInteger);
        }
        return result;
    }

    /**
     * Main method: generates a random number and calculates its power by two methods.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size;
        while (true) {
            System.out.print("Enter the size of the number (positive integer): ");
            if (sc.hasNextInt()) {
                size = sc.nextInt();
                if (size > 0) break;
                System.out.println("Error: number must be greater than 0.");
            } else {
                System.out.println("Error: enter a valid integer!");
                sc.next();
            }
        }

        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();

        BigInteger bigInteger = fillByRandomNumbers(size);
        System.out.println("Generated number: " + bigInteger);

        BigInteger poweredPow = powerByPowFunction(bigInteger, exponent);
        System.out.println("Result using pow(): " + poweredPow);

        BigInteger poweredOwn = powerByOwnFunction(bigInteger, exponent);
        System.out.println("Result using own function: " + poweredOwn);

        System.out.println("Are the results equal? " + poweredPow.equals(poweredOwn));

        sc.close();
    }
}
