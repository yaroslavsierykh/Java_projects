package topicAdd;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        arrayList.add(13);

        int num1 = 15;
        arrayList.add(num1);

        arrayList.addFirst(1);
        arrayList.add(1, 2);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        System.out.println("\n" + arrayList.toString());



        if (arrayList.isEmpty()) {
            System.out.println("Масив порожній");
        }
        else {
            System.out.println(arrayList.toString());
        }

    }
}
