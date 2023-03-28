package Huawei.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ30StringMerge {

    private static final char[] reverseMap = new char[]{'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();


            List<Character> odds = new ArrayList<>();
            List<Character> evens = new ArrayList<>();
            for (int i = 0; i < s1.length() + s2.length(); i++) {
                char ch;
                if (i < s1.length()) {
                    ch = s1.charAt(i);
                } else {
                    ch = s2.charAt(i - s1.length());
                }

                if (i % 2 == 0) {
                    evens.add(ch);
                } else {
                    odds.add(ch);
                }
            }
            odds.sort(Character::compareTo);
            evens.sort(Character::compareTo);

            char[] chars = new char[s1.length() + s2.length()];
            for (int i = 0; i < chars.length; i++) {
                char ch = i % 2 == 0 ? evens.get(i / 2) : odds.get(i / 2);
                chars[i] = ch;
                if (ch >= '0' && ch <= '9') {
                    chars[i] = reverseMap[ch - '0'];
                } else if (ch >= 'a' && ch <= 'f') {
                    chars[i] = reverseMap[ch - 'a' + 10];
                } else if (ch >= 'A' && ch <= 'F') {
                    chars[i] = reverseMap[ch - 'A' + 10];
                }
            }
            System.out.println(new String(chars));
        }

    }

}
