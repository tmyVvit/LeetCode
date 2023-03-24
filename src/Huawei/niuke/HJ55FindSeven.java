package Huawei.niuke;

import java.util.Scanner;

public class HJ55FindSeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            System.out.println(findSeven(a));
        }
    }

    private static int findSeven(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                count++;
            } else {
                int num = i;
                while (num > 0) {
                    if (num % 10 == 7) {
                        count++;
                        break;
                    }
                    num /= 10;
                }
            }
        }
        return count;
    }
}
