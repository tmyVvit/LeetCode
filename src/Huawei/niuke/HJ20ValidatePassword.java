package Huawei.niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ20ValidatePassword {

    private static final String OK = "OK";
    private static final String NG = "NG";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();

            if (lengthCheck(line)) {
                ng();
                continue;
            }

            if (charCheck(line)) {
                ng();
                continue;
            }

            if (duplicateCheck(line)) {
                ng();
                continue;
            }

            ok();
        }
    }

    private static boolean lengthCheck(String line) {
        return line == null || line.length() <= 8;
    }

    private static boolean charCheck(String line) {
        int small = 0, big = 0, number = 0, other = 0;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch >= '0' && ch <= '9') {
                number = 1;
            } else if (ch >= 'a' && ch <= 'z') {
                small = 1;
            } else if (ch >= 'A' && ch <= 'Z') {
                big = 1;
            } else {
                other = 1;
            }

            if (small + big + number + other >= 3) {
                return false;
            }
        }
        return small + big + number + other < 3;
    }

    private static boolean duplicateCheck(String line) {
        Set<String> set = new HashSet<>();
        for (int i = 3; i < line.length(); i++) {
            String sub = line.substring(i - 3, i);
            if (set.contains(sub)) {
                return true;
            } else {
                set.add(sub);
            }
        }
        return false;
    }

    private static void ng() {
        System.out.println(NG);
    }

    private static void ok() {
        System.out.println(OK);
    }
}
