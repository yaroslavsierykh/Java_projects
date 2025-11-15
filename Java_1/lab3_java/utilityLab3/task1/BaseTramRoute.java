package utilityLab3.task1;

/**
 * Абстрактний клас, що представляє трамвайний маршрут.
 * Містить основну інформацію про маршрут і абстрактні методи для роботи із зупинками.
 */
public abstract class BaseTramRoute {
    private String routeNumber;

    /**
     * Повертає номер маршруту.
     *
     * @return номер маршруту
     */
    public String getRouteNumber() {
        return routeNumber;
    }

    /**
     * Встановлює номер маршруту.
     *
     * @param routeNumber новий номер маршруту
     */
    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**
     * Повертає масив зупинок маршруту.
     *
     * @return масив зупинок
     */
    public abstract StopV2[] getStops();

    /**
     * Встановлює масив зупинок маршруту.
     *
     * @param stops масив зупинок
     */
    public abstract void setStops(StopV2[] stops);

    /**
     * Обчислює загальну кількість пасажирів на маршруті.
     *
     * @return загальна кількість пасажирів
     */
    public abstract int calculateTotalPassengers();

    /**
     * Повертає масив зупинок з найменшою кількістю пасажирів.
     *
     * @return масив зупинок з мінімальною кількістю пасажирів
     */
    public abstract StopV2[] findStopsWithFewestPassengers();

    /**
     * Повертає зупинку з найдовшою назвою.
     *
     * @return зупинка з найдовшою назвою
     */
    public abstract StopV2 findStopWithLongestName();

    /**
     * Перевіряє рівність двох маршрутів за номером маршруту.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо об'єкти мають однаковий номер маршруту
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BaseTramRoute that = (BaseTramRoute) obj;
        return routeNumber != null && routeNumber.equals(that.routeNumber);
    }

    /**
     * Повертає хеш-код об'єкта на основі номера маршруту.
     *
     * @return хеш-код маршруту
     */
    @Override
    public int hashCode() {
        return routeNumber != null ? routeNumber.hashCode() : 0;
    }
}
