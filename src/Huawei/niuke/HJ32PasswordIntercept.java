package Huawei.niuke;

import java.util.Scanner;

public class HJ32PasswordIntercept {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.nextLine();
            System.out.println(findLongest(word));
        }
    }

    private static int findLongest(String word) {
        if (word.length() == 1) {
            return 1;
        }

        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < word.length() && word.charAt(l) == word.charAt(r)) {
                l--;r++;
            }
            max = Math.max(max, r - l - 1);

            if (i > 0 && word.charAt(i - 1) == word.charAt(i)) {
                l = i - 1; r = i;
                while (l >= 0 && r < word.length() && word.charAt(l) == word.charAt(r)) {
                    l--;r++;
                }
                max = Math.max(max, r - l - 1);
            }
        }
        return max;
    }

}
