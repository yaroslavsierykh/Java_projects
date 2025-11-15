package lab4.task5_lab4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Асоціативний масив (Map): ім'я -> пароль
        Map<String, String> users = new HashMap<>();

        // Додавання даних (можна змінити або зчитувати з консолі)
        users.put("Ivan", "qwerty");
        users.put("Maria", "superpass");
        users.put("Olga", "123456");
        users.put("Petro", "mypassword123");
        users.put("Dmytro", "abc");

        System.out.println("Користувачі з паролем понад 6 символів:");

        // Фільтрація і вивід
        for (Map.Entry<String, String> entry : users.entrySet()) {
            if (entry.getValue().length() > 6) {
                System.out.println("Ім'я: " + entry.getKey() + ", Пароль: " + entry.getValue());
            }
        }
    }
}

