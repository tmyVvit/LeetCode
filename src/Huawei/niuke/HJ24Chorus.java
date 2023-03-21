package Huawei.niuke;

import java.util.Scanner;

public class HJ24Chorus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int len = sc.nextInt();

            int[] heights = new int[len];
            for (int i = 0; i < len; i++) {
                heights[i] = sc.nextInt();
            }
            int[] left = new int[len];
            int[] right = new int[len];

            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (heights[j] < heights[i]) {
                        left[i] = Math.max(left[i], left[j] + 1);
                    }
                }
            }

            for (int i = len - 1; i >= 0; i--) {
                for (int j = len - 1; j > i; j--) {
                    if (heights[j] < heights[i]) {
                        right[i] = Math.max(right[i], right[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < len; i++) {
                max = Math.max(max, left[i] + right[i] + 1);
            }

            System.out.println(len - max);

        }
    }
}
