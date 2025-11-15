package lab5.task2_lab5;

public class Main {
    public static void main(String[] args) {
        // Демонстрація одного місяця
        Month m = Month.ТРАВЕНЬ;
        System.out.println("Поточний місяць: " + m);
        System.out.println("Днів: " + m.getDays());
        System.out.println("Сезон: " + m.getSeason());
        System.out.println("Попередній місяць: " + m.getPrevious());
        System.out.println("Наступний місяць: " + m.getNext());

        // Виведення всіх місяців
        System.out.println("\nПерелік усіх місяців:");
        Month.printAllMonths();
    }
}

