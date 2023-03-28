package Huawei.niuke;

import java.util.Scanner;

public class HJ65FindLongestSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            String b = in.next();
            System.out.println(find(a, b));
        }
    }

    private static String find(String a, String b) {
        String shorter = a.length() > b.length() ? b : a;
        String longer = shorter == a ? b : a;

        int max = 0;
        String subString = null;
        for (int i = 0; i < shorter.length(); i++) {
            for (int r = shorter.length(); r > i; r--) {
                int len = r - i;
                if (len <= max) {
                    break;
                }
                String sub = shorter.substring(i, r);
                if (longer.contains(sub)) {
                    max = len;
                    subString = sub;
                    break;
                }
            }
        }

        return subString;
    }
}
