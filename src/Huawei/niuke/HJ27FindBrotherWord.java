package Huawei.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ27FindBrotherWord {

    // https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&tqId=21250&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int len = sc.nextInt();
            String[] words = new String[len];
            for (int i = 0; i < len; i++) {
                words[i] = sc.next();
            }
            String target = sc.next();
            int[] targetArr = wordToArray(target);
            int k = sc.nextInt();

            List<String> brotherWords = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (isBrotherWord(target, targetArr, words[i])) {
                    brotherWords.add(words[i]);
                }
            }

            System.out.println(brotherWords.size());

            if (k <= brotherWords.size()) {
                brotherWords.sort(String::compareTo);
                System.out.println(brotherWords.get(k - 1));
            } else {
                System.out.println();
            }

        }

    }

    private static boolean isBrotherWord(String target, int[] targetArr, String word) {
        if (target.equals(word)) {
            return false;
        }

        if (target.length() != word.length()) {
            return false;
        }

        return arrayEqual(targetArr, wordToArray(word));
    }

    private static int[] wordToArray(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        return arr;
    }

    private static boolean arrayEqual(int[] a1, int[] a2) {
        int len = a1.length;
        for (int i = 0; i < len; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
