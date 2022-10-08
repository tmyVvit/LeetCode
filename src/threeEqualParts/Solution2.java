package threeEqualParts;

import java.util.Arrays;

public class Solution2 {

    public int[] threeEqualParts(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1, -1};
        }
        // 1 的个数
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) return new int[]{-1, -1};
        if (sum == 0) return new int[]{0, 2};
        int count = sum/3;
        int index1 = 0, index2 = 0, index3 = 0, count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (count1 == 0) {
                    index1 = i;
                } else if (count1 == count) {
                    index2 = i;
                } else if (count1 == 2*count) {
                    index3 = i;
                }
                count1++;
            }
        }

        while (index3 < arr.length) {
            if (arr[index1] == arr[index2] && arr[index2] == arr[index3]) {
                index1++;
                index2++;
                index3++;
                continue;
            }
            return new int[]{-1, -1};
        }
        return new int[]{index1 - 1, index2};
    }



    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
    }
}
