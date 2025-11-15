package StringSplitter.stringutils;

import java.util.Arrays;

/**
 * Utility class for splitting strings by numbers.
 */
public class SplitString {

    /**
     * Splits the input string by digits and removes empty parts.
     *
     * @param input input string, must be longer than 20 characters
     * @return array of string parts without digits
     * @throws IllegalArgumentException if the input string is null or shorter than 21 characters
     */
    public static String[] splitArrayByNumbers(String input) {
        if (input == null || input.length() <= 20) {
            throw new IllegalArgumentException("Input string must be longer than 20 characters");
        }
        String[] parts = input.split("\\d+");
        return Arrays.stream(parts)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    /**
     * Demo method to test string splitting.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        String test1 = "ab12c d34ef56ghij789klmn";
        String test2 = "a1b2c3d4e5f6g7h8i9j0klmnop";
        String test3 = "aweewew21btrc23d456efghijkl";

        String[] tests = {test1, test2, test3};

        for (int i = 0; i < tests.length; i++) {
            System.out.println("\nTest " + (i + 1) + ". Input string:\t" + tests[i]);
            String[] result = splitArrayByNumbers(tests[i]);
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
