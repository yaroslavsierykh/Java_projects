package lab1;

// звичайний імпорт
import lab1.task5_pac.FunctionLibrary;
// статичний імпорт
import static lab1.task5_pac.FunctionLibrary.*;

public class Task5_1_lab1 {
    public static void main(String[] args) {
        // Звичайний виклик
        System.out.println("boolToInt(true): " + FunctionLibrary.boolToInt(true));
        System.out.println("boolToInt(false): " + FunctionLibrary.boolToInt(false));

        // Статичний імпорт
        System.out.println("intToBool(0): " + intToBool(0));
        System.out.println("intToBool(5): " + intToBool(5));

        // Перевірка функції intToDouble з різними аргументами
        for (int i = -1; i <= 6; i++) {
            System.out.printf("intToDouble(%d): %.4f%n", i, intToDouble(i));
        }
    }
}
