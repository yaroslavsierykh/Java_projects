import utility.Utility;

public class Task5V2 {
    public static void main(String[] args) {
        boolean boolVal = true;
        System.out.println("Boolean to int: " + Utility.booleanToInt(boolVal));

        int intVal = 0;
        System.out.println("Int to boolean: " + Utility.intToBoolean(intVal));

        int n1 = 2;
        System.out.println("Int to double: " + Utility.intToDouble(n1));

        int n2 = 5;
        System.out.println("Int to double: " + Utility.intToDouble(n2));
    }
}
