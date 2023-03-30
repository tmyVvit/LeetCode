package Huawei.niuke;

import java.util.Scanner;

public class HJ95RMBTransfer {

    private static final String[] numbers = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] units0 = new String[]{"拾", "佰", "仟"};
    private static final String[] units1 = new String[]{"角", "分"};
    private static final String[] units2 = new String[]{"元", "万", "亿"};
    private static final String zero = "零";
    private static final String zheng = "整";
    private static final String pre = "人民币";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] rmb = sc.next().split("\\.");

            System.out.println(pre + transfer1(Integer.parseInt(rmb[0]), 0) + transfer0(rmb[1]));
        }


    }

    private static String transfer1(int number, int unit) {
        StringBuilder sb = new StringBuilder();
        boolean pre = false;
        if (number / 10000 > 0) {
            pre = true;
            sb.append(transfer1(number / 10000, unit + 1));
            number %= 10000;
        }

        boolean preZero = false;
        if (number / 1000 > 0) {
            pre = true;
            sb.append(numbers[number / 1000]).append(units0[2]);
            number %= 1000;
        } else {
            preZero = true;
        }

        if (number / 100 > 0) {
            if (pre && preZero) {
                sb.append(zero);
            }
            pre = true;
            sb.append(numbers[number / 100]).append(units0[1]);
            preZero = false;
            number %= 100;
        } else {
            preZero = true;
        }

        if (number / 10 > 0) {
            if (pre && preZero) {
                sb.append(zero);
            }
            preZero = false;
            if (number / 10 > 1) {
                sb.append(numbers[number / 10]);
            }
            sb.append(units0[0]);
            number %= 10;
        } else {
            preZero = true;
        }

        if (number > 0) {
            if (pre && preZero) {
                sb.append(zero);
            }
            sb.append(numbers[number]);
        }
        if (sb.length() > 0) {
            sb.append(units2[unit]);
        }
        return sb.toString();
    }

    // 角 分
    private static String transfer0(String rmb) {
        if ("00".equals(rmb)) {
            return zheng;
        }
        int num = Integer.parseInt(rmb);
        StringBuilder sb = new StringBuilder();
        if (num / 10 > 0) {
            sb.append(numbers[num / 10]).append(units1[0]);
            num %= 10;
        }
        if (num > 0) {
            sb.append(numbers[num]).append(units1[1]);
        }
        return sb.toString();
    }
}
