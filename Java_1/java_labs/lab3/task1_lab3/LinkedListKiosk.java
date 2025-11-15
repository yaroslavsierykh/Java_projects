package lab3.task1_lab3;

/**
 * Кіоск, що зберігає дані у власноруч створеному однобічному списку.
 */
public class LinkedListKiosk extends AbstractKiosk {
    private Node head;

    private static class Node {
        int hour;
        HourData data;
        Node next;

        Node(int hour, HourData data) {
            this.hour = hour;
            this.data = data;
        }
    }

    public LinkedListKiosk(String name, String address) {
        super(name, address);
    }

    @Override
    public void setHourData(int hour, HourData data) {
        Node newNode = new Node(hour, data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    @Override
    public HourData[] getAllHourData() {
        HourData[] result = new HourData[24];
        Node current = head;
        while (current != null) {
            result[current.hour] = current.data;
            current = current.next;
        }
        return result;
    }
}

