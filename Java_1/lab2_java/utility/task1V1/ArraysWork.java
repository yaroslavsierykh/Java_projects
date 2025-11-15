package utility.task1V1;

public class ArraysWork {
    /**
     * Метод для заповнення двовимірного масиву випадковими цілими числами.
     * Кожен елемент масиву заповнюється випадковим числом в діапазоні від 5 до 21
     * (не включаючи 21), причому числа є непарними.
     *
     * @param arr Двовимірний масив, який буде заповнено випадковими числами.
     */
    public static void fillArray(int[][] arr) {
        // Проходимо по кожному рядку масиву
        for (int i = 0; i < arr.length; i++) {
            // Проходимо по кожному елементу рядка
            for (int j = 0; j < arr[i].length; j++) {
                // Генерація випадкового непарного числа від 5 до 21
                int randomNumber = 5 + 2 * (int) (Math.random() * ((21 - 5) / 2 + 1));
                arr[i][j] = randomNumber;  // Запис випадкового числа в елемент масиву
            }
        }
    }

    /**
     * Метод для пошуку максимальних значень в кожному стовпці двовимірного масиву.
     * В результаті обчислення повертається одномірний масив, який містить
     * максимальне значення для кожного стовпця.
     *
     * @param arr Двовимірний масив цілих чисел.
     * @return Масив цілих чисел, де кожен елемент є максимальним значенням відповідного стовпця масиву.
     */
    public static int[] findMaxValues(int[][] arr) {
        // Ініціалізуємо масив для збереження максимальних значень
        int[] maxValues = new int[arr[0].length];

        // Початково кожен стовпець розглядається з першим елементом
        for (int j = 0; j < arr[0].length; j++) {
            maxValues[j] = arr[0][j];  // Встановлюємо перше значення як максимальне
        }

        // Перевіряємо інші елементи масиву та оновлюємо максимальні значення
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxValues[j]) {
                    maxValues[j] = arr[i][j];  // Оновлюємо максимальне значення, якщо поточне більше
                }
            }
        }

        // Повертаємо масив максимальних значень
        return maxValues;
    }

    public static void printArrayInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void printArrayStr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String[] arrayStringFill(int[] arr) {
        String[] stringArray = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String str = "";
            for (int j = 0; j < arr[i]; j++) {
                str += "Y";
            }
            stringArray[i] = str;
        }

        return stringArray;
    }

    public static void sortArrayString(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].length() < arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
