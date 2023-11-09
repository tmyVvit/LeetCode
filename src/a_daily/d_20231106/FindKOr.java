package a_daily.d_20231106;

// https://leetcode.cn/problems/find-the-k-or-of-an-array/
public class FindKOr {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count >= k) {
                ans |= mask;
            }
        }
        return ans;
    }
}
