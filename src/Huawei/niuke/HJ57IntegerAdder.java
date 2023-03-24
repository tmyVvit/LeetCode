package Huawei.niuke;

import java.util.Scanner;

public class HJ57IntegerAdder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String l1 = sc.nextLine();
            String l2 = sc.nextLine();

            System.out.println(add(l1, l2));
        }

    }

    private static String add(String s1, String s2) {
        int carry = 0;
        int idx1 = s1.length() - 1;
        int idx2 = s2.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            int ch1 = idx1 >= 0 ? s1.charAt(idx1) - '0' : 0;
            int ch2 = idx2 >= 0 ? s2.charAt(idx2) - '0' : 0;

            int res = ch1 + ch2 + carry;
            carry = res / 10;
            res = res % 10;
            ans.insert(0, res);
            idx1--;
            idx2--;
        }
        if (carry > 0) {
            ans.insert(0, carry);
        }

        return ans.toString();
    }
}
