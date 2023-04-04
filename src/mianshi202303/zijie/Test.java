package mianshi202303.zijie;

import java.util.Scanner;

public class Test {

    // 找到第一个缺失的正整数
    // 要求时间复杂度 O(n), 空间复杂度 O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(find(arr));
        }
    }

    // 令 len 为数组的长度，那么缺失的正整数范围肯定是在 [1, len + 1] 之间的
    // 我们可以考虑下标的方式，数组的下标范围定义为 [1, len]
    // 遍历数组，将数组的值放入对应的下标上，再次从小到大遍历的时候下标不等于值的那一个下标就是缺失的最小正整数
    public static int find(int[] arr) {
        int len = arr.length;
        int idx = 0;
        while (idx < len) {
            // 如果当前的值已经就是下标，或者值不再 [1，len] 范围内，跳过
            if (arr[idx] == idx + 1 || arr[idx] <= 0 || arr[idx] > len) {
                idx++;
                continue;
            }

            // 交换
            int tidx = arr[idx] - 1;
            int tmp = arr[idx];
            arr[idx] = arr[tidx];
            arr[tidx] = tmp;

            // 如果交换前后的值相同，则可以跳过
            if (arr[idx] == tmp) {
                idx++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
