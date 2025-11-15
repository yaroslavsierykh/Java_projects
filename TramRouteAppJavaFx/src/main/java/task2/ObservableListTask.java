package task2;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableListTask {

    public static ObservableList<Double> fillListByRandom(int size) {
        ObservableList<Double> list = FXCollections.observableArrayList();

        for (int i = 0; i < size; i++) {
            if (Math.random() > 0.5) {
                list.add(Math.random() * 100);
            } else {
                list.add(-Math.random() * 100);
            }
        }
        return list;
    }

    public static void printList(String message, ObservableList<Double> list) {
        System.out.println(message);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(" [%d] %.2f%n", i, list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ObservableList<Double> numbers = fillListByRandom(10);

        numbers.addListener((ListChangeListener<Double>) change -> {
            printList("Поточний стан списку:", numbers);
        });

        printList("Початковий список:", numbers);

        ObservableList<Double> positives = FXCollections.observableArrayList();
        ObservableList<Double> negatives = FXCollections.observableArrayList();

        for (Double number : numbers) {
            if (number >= 0) {
                positives.add(number);
            }
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) < 0) {
                negatives.add(numbers.get(i));
            }
        }

        numbers.clear();
        numbers.addAll(positives);
        numbers.addAll(negatives);

        printList("Кінцевий список:", numbers);
    }
}
