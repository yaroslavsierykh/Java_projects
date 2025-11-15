package utility.task4;

public class JustifyText {
    public static String justify(String input, int targetLength) {
        String[] words = input.trim().split(" +");
        if(words.length == 1 || input.length() >= targetLength) {
            return input;
        }

        int lettersCount = 0;
        for (String word : words) {
            lettersCount += word.length();
        }

        int totalSpaces = targetLength - lettersCount;
        int gaps = words.length - 1;
        int baseSpaces = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < gaps) {
                int spaces = baseSpaces + (i < extraSpaces ? 1 : 0);
                result.append(" ".repeat(spaces));
            }
        }
        return result.toString();
    }
}
