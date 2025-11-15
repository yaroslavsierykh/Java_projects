package lab1.task5_pac;

public class FunctionLibrary {
    // boolean → int
    public static int boolToInt(boolean value) {
        return value ? 1 : 0;
    }

    // int → boolean
    public static boolean intToBool(int value) {
        return value != 0;
    }

    // int → double з використанням switch
    public static double intToDouble(int n) {
        switch (n) {
            case 0: return 2;
            case 1: return 4;
            case 2: return 5;
            case 3: return 3;
            case 4: return 1;
            default: return n + Math.sin(n);
        }
    }
}
