package advantageShuffle;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 创建 nums2 的下标数组，并对下标数组根据 nums2 排序
        Integer[] idx2 = new Integer[nums2.length];
        for (int i = 0;i < idx2.length; i++) {
            idx2[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(idx2, Comparator.comparingInt(a -> nums2[a]));
        int l = 0, r = nums2.length - 1;
        for (int num : nums1) {
            if (num > nums2[idx2[l]]) {
                nums2[idx2[l]] = num;
                l++;
            } else {
                nums2[idx2[r]] = num;
                r--;
            }
        }
        return nums2;
    }
}
