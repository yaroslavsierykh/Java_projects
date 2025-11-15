import utilityLab5.task2.Month;

public class Lab5Task2 {
    public static void main(String[] args) {
        Month current = Month.КВІТЕНЬ;

        System.out.println("Поточний місяць: " + current);
        System.out.println("Наступний: " + current.getNext());
        System.out.println("Попередній: " + current.getPrevious());
        System.out.println("Сезон: " + current.getSeason());

        System.out.println("\nУсі місяці:");
        Month.printAllMonths();
    }
}
