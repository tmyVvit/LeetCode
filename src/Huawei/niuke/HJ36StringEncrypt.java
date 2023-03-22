package Huawei.niuke;

import java.util.Scanner;

public class HJ36StringEncrypt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String key = sc.nextLine();
            String word = sc.nextLine();
            System.out.println(encrypt(key, word));
        }
    }

    // 只包含小写字母
    private static String encrypt(String key, String word) {
        int[] map = new int[26];
        char[] mask = new char[26];
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (map[idx] == 0) {
                map[idx] = 1;
                mask[index++] = key.charAt(i);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) {
                mask[index++] = (char) ('a' + i);
            }
        }

        char[] res = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (isLetter(ch)) {
                res[i] = mask[ch - 'a'];
            } else {
                res[i] = ch;
            }
        }
        return new String(res);
    }

    private static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
