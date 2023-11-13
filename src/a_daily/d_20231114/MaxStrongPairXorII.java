package a_daily.d_20231114;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxStrongPairXorII {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        int mask = 0;
        Arrays.sort(nums);
        for (int i = 30; i >= 0; i--) {
            mask |= 1 << i;
            int newMax = max | (1 << i);
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int numMask = num & mask;
                int mr = numMask ^ newMax;
                if (map.containsKey(mr) && 2 * map.get(mr) >= num) {
                    max = newMax;
                    break;
                }
                map.put(numMask, num);
            }
        }
        return max;
    }
}
