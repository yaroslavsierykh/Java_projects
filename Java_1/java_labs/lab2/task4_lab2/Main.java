package lab2.task4_lab2;

/**
 * Клас для тестування функції вирівнювання тексту по ширині.
 */
public class Main {
    public static void main(String[] args) {
        String input = "Це приклад тексту для вирівнювання";
        int targetLength = 40;

        System.out.println("Вхідний текст:");
        System.out.println(input);

        String justified = JustifyText.justify(input, targetLength);

        System.out.println("\nВирівняний текст (довжина " + targetLength + "):");
        System.out.println("'" + justified + "'");
        System.out.println("Довжина рядка: " + justified.length());
    }
}

