package a_daily.d_20231015;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];

        for (int num : nums) {
            c(num, count);
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    private void c(int num, int[] count) {
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count[i]++;
            }
            num >>= 1;
        }
    }
}
