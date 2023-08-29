package a_day20230829;

import java.util.Arrays;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(transfer(words[i], i));
        }

        return sb.toString();
    }

    private static String transfer(String word, int index) {
        if (isVowel(word.charAt(0))) {
            return word + "ma" + copyN('a', index + 1);
        } else {
            return (word + word.charAt(0) + "ma" + copyN('a', index + 1)).substring(1);
        }


    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }

    private static String copyN(char ch, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, ch);
        return new String(arr);
    }
}
