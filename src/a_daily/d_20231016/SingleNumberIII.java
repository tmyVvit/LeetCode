package a_daily.d_20231016;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int xor = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int a = 0, b = 0;
        int idx = getFirstOne(xor);
        for (int num : nums) {
            if (((num >> idx) & 1) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    private int getFirstOne(int num) {
        int i = 0;
        while (((num >> i) & 1) == 0) {
            i++;
        }
        return i;
    }
}
