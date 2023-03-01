package subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        // k:v 表示前缀和为 k 有 v 个
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
        }
        return count;
    }

}
