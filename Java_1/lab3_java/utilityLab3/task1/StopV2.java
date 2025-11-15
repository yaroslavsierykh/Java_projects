package utilityLab3.task1;

import java.util.Objects;

/**
 * Клас, що представляє зупинку на маршруті.
 * Містить назву зупинки та кількість пасажирів.
 */
public class StopV2 implements Comparable<StopV2> {
    private String name;
    private int passengers;

    /**
     * Конструктор для створення зупинки.
     *
     * @param name       назва зупинки
     * @param passengers кількість пасажирів на зупинці
     */
    public StopV2(String name, int passengers) {
        this.name = name;
        this.passengers = passengers;
    }

    /**
     * Повертає назву зупинки.
     *
     * @return назва зупинки
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає кількість пасажирів на зупинці.
     *
     * @return кількість пасажирів
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Встановлює нову назву зупинки.
     *
     * @param name нова назва
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Встановлює нову кількість пасажирів.
     *
     * @param passengers нове значення пасажирів
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Перевіряє рівність двох зупинок за назвою і кількістю пасажирів.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо зупинки однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StopV2 stop = (StopV2) obj;
        return passengers == stop.passengers && Objects.equals(name, stop.name);
    }

    /**
     * Генерує хеш-код для зупинки.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, passengers);
    }

    /**
     * Повертає рядкове представлення зупинки.
     *
     * @return рядок з інформацією про зупинку
     */
    @Override
    public String toString() {
        return "StopV2{name='" + name + "', passengers=" + passengers + "}";
    }

    /**
     * Порівнює зупинки за кількістю пасажирів.
     *
     * @param other інша зупинка
     * @return результат порівняння
     */
    @Override
    public int compareTo(StopV2 other) {
        return Integer.compare(this.passengers, other.passengers);
    }
}
