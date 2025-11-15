import static utility.task1V1.ArraysWork.*;

/**
 * Клас для тестування алгоритмів роботи з масивами.
 * Виконує заповнення двовимірного масиву випадковими значеннями, знаходження
 * максимальних значень по стовпцях, створення масиву рядків на основі максимальних значень,
 * а також сортування цього масиву рядків.
 */
public class Lab2Task1V1 {

    /**
     * Головний метод програми, що виконується при запуску.
     * Виконує тестування заповнення масиву, пошуку максимальних значень,
     * формування масиву рядків та сортування цього масиву.
     *
     * @param args Масив параметрів командного рядка (не використовується).
     */
    public static void main(String[] args) {
        // Створення двовимірного масиву 4х6
        int[][] array = new int[4][6];

        // Заповнення масиву значеннями
        fillArray(array);

        // Виведення елементів масиву для перевірки
        System.out.println("Fill array: ");
        System.out.println(array[1][3]); // Виведення елемента з рядка 1, стовпця 3
        System.out.println(array[2][3]); // Виведення елемента з рядка 2, стовпця 3
        System.out.println(array[3][4]); // Виведення елемента з рядка 3, стовпця 4
        System.out.println(array[3][5]); // Виведення елемента з рядка 3, стовпця 5

        // Виведення масиву максимальних значень для кожного стовпця
        System.out.println("Printing array of max values: ");
        printArrayInt(findMaxValues(array));

        // Створення масиву рядків на основі максимальних значень
        System.out.println("Printing array of strings: ");
        String[] result =  arrayStringFill(findMaxValues(array));

        // Виведення масиву рядків
        printArrayStr(result);

        // Сортування масиву рядків та виведення його після сортування
        System.out.println("Printing sorted array : ");
        sortArrayString(result);
        printArrayStr(result);
    }
}
