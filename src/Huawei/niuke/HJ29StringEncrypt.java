package Huawei.niuke;

import java.util.Scanner;

public class HJ29StringEncrypt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();

            System.out.println(encrypt(line1, true));
            System.out.println(encrypt(line2, false));
        }
    }

    private static String encrypt(String str, boolean encrypt) {
        char[] chars = new char[str.length()];
        int offset = encrypt ? 1 : -1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= '9' && ch >= '0') {
                chars[i] = encryptNumber(ch, offset);
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z' )) {
                chars[i] = encryptLetter(ch, offset);
            } else {
                chars[i] = ch;
            }
        }

        return new String(chars);
    }

    private static char encryptLetter(char ch, int offset0) {
        if (ch >= 'a' && ch <= 'z') {
            int offset = ch - 'a';
            return (char)( 'A' + (offset + offset0 + 26) % 26);
        }
        if (ch >= 'A' && ch <= 'Z') {
            int offset = ch - 'A';
            return (char)( 'a' + (offset + offset0 + 26) % 26);
        }
        return ch;
    }

    private static char encryptNumber(char ch, int offset0) {
        int offset = ((ch - '0') + offset0 + 10) % 10;
        return (char) ('0' + offset);
    }

}
