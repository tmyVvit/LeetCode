package jianzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // 桶排序思想，设桶大小为 t + 1，那么在桶一个桶里的元素必然满足条件
    // 在相邻桶里的元素，只需要计算差值是否 <= t 即可
    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        Map<Long, Long> bucket = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long bucketId = bucketId(nums[i], t + 1);
            if (bucket.containsKey(bucketId)) {
                return true;
            }

            if (bucket.containsKey(bucketId - 1) && nums[i] - bucket.get(bucketId - 1) <= t) {
                return true;
            }

            if (bucket.containsKey(bucketId + 1) && bucket.get(bucketId + 1) - nums[i] <= t) {
                return true;
            }
            bucket.put(bucketId, (long) nums[i]);
            if (i >= k) {
                bucket.remove(bucketId(nums[i - k], t + 1));
            }
        }
        return false;
    }

    private long bucketId(long num, long k) {
        if (num >= 0) {
            return num / k;
        }
        return (num + 1) / k - 1;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate s = new ContainsNearbyAlmostDuplicate();
        int[] arr = {2147483647,-1, -2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(s.containsNearbyAlmostDuplicate0(arr, k, t));

    }

}
