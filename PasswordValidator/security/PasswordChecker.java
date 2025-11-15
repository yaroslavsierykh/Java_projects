package PasswordValidator.security;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static boolean isPasswordValid(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[_\\-*;])[A-Za-z\\d_\\-*;]+$";;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }

    public static void printCondition() {
        System.out.println("Вимоги до пароля:");
        System.out.println("1. Має містити хоча б одну маленьку літеру (a-z)");
        System.out.println("2. Має містити хоча б одну велику літеру (A-Z)");
        System.out.println("3. Має містити хоча б одну цифру (0-9)");
        System.out.println("4. Має містити хоча б один спеціальний символ: _ - * ;");
        System.out.println("5. Може містити лише літери латинського алфавіту, цифри та спецсимволи: _ - * ;");

    }

    public static void main(String[] args) {
        printCondition();
        while (true) {
            String input = new Scanner(System.in).nextLine();
            if (Objects.equals(input, "exit")) {break;}

            switch (isPasswordValid(input) ? "correct": "invalid") {
                case "correct" -> System.out.println("Пароль надійний!");
                case "invalid" -> System.out.println("Пароль не підходить під умови, спробуйте ще раз");
            }
        }
    }
}
