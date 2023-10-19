package a_daily.d_20231019;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {


    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }
        int ans = 0;
        for (int v : map.values()) {
            ans += v * (v - 1) * 4;
        }
        return ans;
    }

}
