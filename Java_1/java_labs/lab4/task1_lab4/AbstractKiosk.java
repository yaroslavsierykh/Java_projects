package lab4.task1_lab4;

import java.io.Serializable;
import java.util.Objects;

/**
 * Абстрактний клас для опису кіоску без зберігання послідовності годин.
 */
public abstract class AbstractKiosk implements Serializable {
    private String name;
    private String address;

    public AbstractKiosk(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public abstract HourData[] getAllHourData();

    public abstract void setHourData(int hour, HourData data);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractKiosk)) return false;
        AbstractKiosk that = (AbstractKiosk) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
