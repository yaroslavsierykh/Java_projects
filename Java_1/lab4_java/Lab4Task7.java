import utilityLab4.task7.DoubleLinkedList;

public class Lab4Task7 {
    public static void main(String[] args) {
        System.out.println("===== Перевірка для String =====");
        DoubleLinkedList<String> stringList = new DoubleLinkedList<>();

        stringList.addFirst("Hello");
        stringList.addLast("World");

        System.out.println("Прямий обхід:");
        stringList.print();

        System.out.println("------");

        System.out.println("Зворотний обхід:");
        stringList.printReverse();

        stringList.addByIndex("SomeWord", 1);
        System.out.println("\nПісля додавання 'SomeWord' на позицію 1:");
        stringList.print();

        System.out.println("\nВидалення першого елемента:");
        stringList.removeFirst();
        stringList.print();

        System.out.println("\nВидалення останнього елемента:");
        stringList.removeLast();
        stringList.print();

        System.out.println("\nВидалення елемента 'SomeWord':");
        stringList.removeByValue("SomeWord");
        stringList.print();

        System.out.println("\nДодавання елементу для перевірки");
        stringList.addFirst("CheckWord");

        System.out.println("\nЧи містить список 'CheckWord'? " + (stringList.contains("CheckWord") ? "так" : "ні"));
        System.out.println("Розмір списку: " + stringList.size());

        stringList.clear();
        System.out.println("Список очищено. Розмір: " + stringList.size());

        System.out.println("\n===== Перевірка для Integer =====");
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        intList.addFirst(10);
        intList.addLast(20);

        System.out.println("Прямий обхід:");
        intList.print();

        System.out.println("------");

        System.out.println("Зворотний обхід:");
        intList.printReverse();

        intList.addByIndex(15, 1); // вставка між 10 і 20

        System.out.println("\nПісля додавання 15 на позицію 1:");
        intList.print();

        System.out.println("\nВидалення першого елемента:");
        intList.removeFirst();
        intList.print();

        System.out.println("\nВидалення останнього елемента:");
        intList.removeLast();
        intList.print();

        System.out.println("\nВидалення значення 15:");
        intList.removeByValue(15);
        intList.print();

        System.out.println("\nДодавання значення 99:");
        intList.addFirst(99);
        intList.print();

        System.out.println("\nЧи містить список 99? " + (intList.contains(99) ? "так" : "ні"));
        System.out.println("Розмір списку: " + intList.size());

        intList.clear();
        System.out.println("Список очищено. Розмір: " + intList.size());
    }
}
