package utilityLab3.task1;

/**
 * Реалізація маршруту трамвая з використанням однобічного зв'язаного списку зупинок
 */
public class TramRouteWithLinkedList extends BaseTramRoute {

    /**
     * Внутрішній клас вузла списку
     */
    private class Node {
        StopV2 stop;
        Node next;
    }

    private Node head = null;
    private int size = 0;

    public TramRouteWithLinkedList(String routeNumber) {
        setRouteNumber(routeNumber);
    }

    @Override
    public StopV2[] getStops() {
        StopV2[] array = new StopV2[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.stop;
            current = current.next;
        }
        return array;
    }

    @Override
    public void setStops(StopV2[] stops) {
        clearStops();
        for (StopV2 stop : stops) {
            addStop(stop);
        }
    }

    public boolean addStop(StopV2 stop) {
        Node newNode = new Node();
        newNode.stop = stop;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public void clearStops() {
        head = null;
        size = 0;
    }

    @Override
    public int calculateTotalPassengers() {
        int total = 0;
        Node current = head;
        while (current != null) {
            total += current.stop.getPassengers();
            current = current.next;
        }
        return total;
    }

    @Override
    public StopV2[] findStopsWithFewestPassengers() {
        if (head == null) return new StopV2[0];
        int min = head.stop.getPassengers();
        Node current = head.next;
        while (current != null) {
            if (current.stop.getPassengers() < min) {
                min = current.stop.getPassengers();
            }
            current = current.next;
        }

        int count = 0;
        current = head;
        while (current != null) {
            if (current.stop.getPassengers() == min) count++;
            current = current.next;
        }

        StopV2[] result = new StopV2[count];
        int index = 0;
        current = head;
        while (current != null) {
            if (current.stop.getPassengers() == min) {
                result[index++] = current.stop;
            }
            current = current.next;
        }

        return result;
    }

    @Override
    public StopV2 findStopWithLongestName() {
        if (head == null) return null;
        StopV2 longest = head.stop;
        Node current = head.next;
        while (current != null) {
            if (current.stop.getName().length() > longest.getName().length()) {
                longest = current.stop;
            }
            current = current.next;
        }
        return longest;
    }
}
