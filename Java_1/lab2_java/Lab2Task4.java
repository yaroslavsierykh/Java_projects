import static utility.task4.JustifyText.*;

public class Lab2Task4 {
    public static void main(String[] argc) {
        if (argc.length < 2) {
            System.out.println("Usage: java Lab2Task4 \"text here\" targetLength");
            return;
        }

        String input = argc[0];
        int length = Integer.parseInt(argc[1]);

        String result = justify(input, length);
        System.out.println(result);
    }
}
