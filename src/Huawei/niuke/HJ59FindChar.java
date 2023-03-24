package Huawei.niuke;

import java.util.Scanner;

public class HJ59FindChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            findChar(str);
        }
    }

    private static void findChar(String str) {
        int[] chars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }

        boolean find = false;
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i) - 'a'] == 1) {
                find = true;
                System.out.println(str.charAt(i));
                break;
            }
        }
        if (!find) {
            System.out.println(-1);
        }
    }
}
