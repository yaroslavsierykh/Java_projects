package lab2.task5_lab2;

/**
 * Клас, що представляє цілодобовий кіоск.
 */
public class Kiosk {
    private String name;
    private String address;
    private HourData[] hourlyData;

    public Kiosk(String name, String address) {
        this.name = name;
        this.address = address;
        this.hourlyData = new HourData[24]; // по 1 годині
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public HourData[] getHourlyData() {
        return hourlyData;
    }

    public void setHourData(int hour, HourData data) {
        if (hour >= 0 && hour < 24) {
            hourlyData[hour] = data;
        }
    }
}

