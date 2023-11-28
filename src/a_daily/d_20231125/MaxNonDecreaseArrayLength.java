package a_daily.d_20231125;

import java.util.Arrays;

public class MaxNonDecreaseArrayLength {

    public static void main(String[] args) {
        MaxNonDecreaseArrayLength s = new MaxNonDecreaseArrayLength();
        System.out.println(s.findMaximumLength(new int[]{313,27,711,570,609}));
        System.out.println(s.findMaximumLength(new int[]{4, 3, 2, 6}));
    }

    public int findMaximumLength(int[] nums) {
        int[] res = new int[nums.length + 1];
//        Arrays.fill(res, 100001);
        res[0] = 0;
        int idx = 1;
        int delCount = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] >= res[idx - 1]) {
                res[idx++] = nums[i++];
            } else {
                int del = 0;
                // i
                int l = i + 1;
                int sum = nums[i];
                while (l < nums.length && (sum < res[idx-1] || sum > nums[l])) {
                    del++;
                    sum += nums[l];
                    l++;
                }
                if (sum < res[idx-1]) {
                    del = 0;
                }

                // i-1
                int del1 = 1;
                int sum1 = res[idx-1] + nums[i];
                int l1 = i + 1;
                while (l1 < nums.length && sum1 > nums[l1]) {
                    del1++;
                    sum1 += nums[l1++];
                }

                if (del == 0 || l1 < l || (l1 == l && sum1 <= sum)) {
                    res[idx - 1] = sum1;
                    delCount += del1;
                    i = l1;
                } else {
                    res[idx++] = sum;
                    delCount += del;
                    i = l;
                }
            }
        }
        return nums.length - delCount;
    }

}
