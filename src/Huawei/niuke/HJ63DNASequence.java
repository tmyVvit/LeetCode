package Huawei.niuke;

import java.util.Scanner;

public class HJ63DNASequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String dna = sc.next();
            int n = sc.nextInt();
            System.out.println(find(dna, n));
        }
    }

    private static String find(String dna, int n) {
        int l = 0, r = 0;
        int max = 0, start = 0;
        while (r < n) {
            char ch = dna.charAt(r);
            if (isCG(ch)) {
                max++;
            }
            r++;
        }

        int num = max;
        while (r < dna.length()) {
            if (isCG(dna.charAt(l))) {
                num--;
            }
            l++;
            if (isCG(dna.charAt(r))) {
                num++;
            }
            r++;
            if (num > max) {
                max = num;
                start = l;
            }
        }
        return dna.substring(start, start + n);
    }

    private static boolean isCG(char ch) {
        return 'C' == ch || 'G' ==ch;
    }
}
