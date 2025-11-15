package PhoneNumberValidator.phonenumber;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for validating Ukrainian phone numbers and detecting Kyivstar operator.
 */
public class PhoneNumberChecker {

    /**
     * Checks if the phone number belongs to Kyivstar operator.
     *
     * @param phoneNumber phone number as string
     * @return true if Kyivstar, false otherwise
     */
    public static boolean isKyivstar(String phoneNumber) {
        String regex = "^(?:\\+380|0)(67|68|96|97|98|77)\\d{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    /**
     * Checks if the string is a valid Ukrainian phone number.
     *
     * @param phoneNumber phone number as string
     * @return true if valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(?:\\+380|0)\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    /**
     * Interactive console program for checking phone numbers.
     * Enter "exit" to quit.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone numbers (type 'exit' to quit):");

        while (true) {
            String input = scanner.nextLine();
            if (Objects.equals(input, "exit")) {
                break;
            }

            if (!isValidPhoneNumber(input)) {
                System.out.println("Invalid phone number");
            } else if (isKyivstar(input)) {
                System.out.println("Operator: Kyivstar");
            } else {
                System.out.println("Operator: Unknown");
            }
        }

        scanner.close();
    }
}
