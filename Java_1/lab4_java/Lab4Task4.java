import utilityLab4.task4.StringWork;
import java.util.SortedSet;
import java.util.Scanner;

public class Lab4Task4 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a sentence:");
        String sentence = scanner.nextLine();

        StringWork stringWork = new StringWork();
        SortedSet<String> sortedWords = stringWork.getSortedWords(sentence);
        stringWork.printSortedWords(sortedWords);
    }
}
