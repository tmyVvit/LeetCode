package a_day20230905;

// https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/description/?envType=daily-question&envId=2023-09-05
public class FormSmallestNum {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        int min1 = 0, min2 = 0;
        for (int i : nums1) {
            a1[i] = 1;
        }
        for (int i : nums2) {
            a2[i] = 1;
        }

        for (int i = 1; i < 10; i++) {
            if (a1[i] != 0 && a2[i] != 0) {
                return i;
            } else if (a1[i] != 0) {
                min1 = min1 == 0 ? i : min1;
            } else if (a2[i] != 0) {
                min2 = min2 == 0 ? i : min2;
            }
        }
        int min = Math.min(min1, min2);
        int max = Math.max(min1, min2);
        return min * 10 + max;
    }
}
