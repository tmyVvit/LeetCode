package Huawei.niuke;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HJ42NumberToEnglish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            System.out.println(numberToEnglish(number));
        }


    }

    private static final String[] num0 = new String[]{
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] num2 = new String[]{
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String hundred = "hundred";

    private static final String[] units = new String[]{"","thousand", "million", "billion"};

    private static String numberToEnglish(int num) {
        return numberToEnglish(num, 0);
    }

    private static String numberToEnglish(int num, int index) {
        StringBuilder prefix = new StringBuilder();
        if (num / 1000 > 0) {
            prefix.append(numberToEnglish(num / 1000, index + 1));
            num %= 1000;
        }
        if (num == 0) {
            return prefix.toString();
        }

        boolean needAnd = false;
        if (num / 100 > 0) {
            prefix.append(" ").append(num0[num / 100 - 1]).append(" ").append(hundred);
            num %= 100;
            needAnd = true;
        }

        if (num == 0) {
            return prefix.toString().trim();
        }
        if (needAnd) {
            prefix.append(" and");
        }
        if (num < 20) {
            prefix.append(" ").append(num0[num - 1]);
        } else {
            prefix.append(" ").append(num2[num / 10 - 2]);
            if (num % 10 > 0) {
                prefix.append(" ").append(num0[num % 10 - 1]);
            }

        }
        if (index > 0) {
            prefix.append(" ").append(units[index]);
        }

        return prefix.toString().trim();
    }

}
