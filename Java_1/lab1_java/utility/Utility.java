package utility;

public class Utility {

    public static int booleanToInt(boolean value) {
        return value ? 1 : 0;
    }

    public static boolean intToBoolean(int value) {
        return value != 0;
    }

    public static double intToDouble(int n) {
        return switch (n) {
            case 0 -> 2.0;
            case 1 -> 4.0;
            case 2 -> 5.0;
            case 3 -> 3.0;
            case 4 -> 1.0;
            default -> n + Math.sin(n);
        };
    }
}
