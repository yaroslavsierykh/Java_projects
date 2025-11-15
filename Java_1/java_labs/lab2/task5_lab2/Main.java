package lab2.task5_lab2;
/**
 * Клас для демонстрації роботи з класами "Цілодобовий кіоск" і "Година".
 */
public class Main {
    public static void main(String[] args) {
        // Створення кіоску
        Kiosk kiosk = new Kiosk("24/7 Drinks", "вул. Свободи, 12");

        // Дані за окремі години (для прикладу)
        kiosk.setHourData(0, new HourData(5, "Тихий початок доби"));
        kiosk.setHourData(1, new HourData(2, "Майже безлюдно"));
        kiosk.setHourData(8, new HourData(20, "Ранковий наплив офісних працівників"));
        kiosk.setHourData(12, new HourData(30, "Година пік"));
        kiosk.setHourData(23, new HourData(3, "П'яні студенти"));

        // Виведення загальної інформації про кіоск
        System.out.println("Інформація про кіоск:");
        System.out.println("Назва: " + kiosk.getName());
        System.out.println("Адреса: " + kiosk.getAddress());
        System.out.println("\nДані за годинами:");

        HourData[] hours = kiosk.getHourlyData();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] != null) {
                System.out.printf("Година %02d: %d покупців, коментар: \"%s\"\n",
                        i, hours[i].getCustomers(), hours[i].getComment());
            }
        }

        // Виведення загальної кількості покупців
        int total = KioskSearchHelper.getTotalCustomers(kiosk);
        System.out.println("\nЗагальна кількість покупців: " + total);

        // Знаходження години з найменшою кількістю покупців
        int minHour = KioskSearchHelper.getHourWithLeastCustomers(kiosk);
        System.out.println("Година з найменшою кількістю покупців: " + minHour);

        // Пошук коментарів зі словом "пік"
        String keyword = "пік";
        String[] comments = KioskSearchHelper.getCommentsContaining(kiosk, keyword);
        System.out.println("\nКоментарі, що містять слово '" + keyword + "':");
        if (comments != null) {
            for (String comment : comments) {
                System.out.println(" - " + comment);
            }
        } else {
            System.out.println("Не знайдено коментарів із цим словом.");
        }
    }
}
