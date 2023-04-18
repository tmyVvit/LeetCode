package mianshi202303.zijie;

import java.util.Arrays;
import java.util.LinkedList;

// 懂车帝
public class FindMaxNumber {

    public static void main(String[] args) {
        FindMaxNumber find = new FindMaxNumber();
        int[] arr = new int[]{2, 3, 4, 9};
        System.out.println(find.findMaxNumberLessThanTarget(23321, arr));
    }

    // 找到小于给定数字的最大数字：给定数字n，以及一个数组arr，找到一个每一位由 arr 里的数字组成，并且小于 n 的最大数字。
    // 例如：n: 23141, arr: [2, 4, 9], result: 22999

    public int findMaxNumberLessThanTarget(int target, int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        while (target > 0) {
            list.addFirst(target % 10);
            target /= 10;
        }
        int[] targets = new int[list.size()];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = list.get(i);
        }

        Arrays.sort(arr);
        return find(0, targets, arr, 0, true);
    }

    private int find(int idx, int[] target, int[] arr, int res, boolean equals) {
        if (idx == target.length) {
            return res;
        }
        if (!equals) {
            return find(idx + 1, target, arr, res * 10 + arr[arr.length - 1], equals);
        }

        int maxIndex = ceiling(arr, target[idx]);
        while (maxIndex >= 0) {
            equals = arr[maxIndex] == target[idx];
            int result = find(idx + 1, target, arr, res * 10 + arr[maxIndex], equals);
            if (result != -1) {
                return result;
            }
            maxIndex--;
        }
        return -1;
    }

    // 找到小于等于 num 的最大值的下标
    private int ceiling(int[] arr, int num) {
        return findCeiling(arr, num, 0, arr.length - 1);
    }

    // 2, 3, 5, 8, 10     6
    private int findCeiling(int[] arr, int num, int l, int r) {
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] <= num) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return arr[l] > num ? l - 1 : l;
    }
}
