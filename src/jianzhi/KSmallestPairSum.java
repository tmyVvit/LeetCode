package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 优先级队列，根据和排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        int m = nums1.length;
        int n = nums2.length;

        // 因为 nums1, nums2 都是升序排列
        // 可以先将所有 (i, 0) 放入队列中
        // 每次队头元素(i, j)就是最小值，然后放入 (i, j+1)
        //      对于元素 (i, j), 下一个是 (i+1, j) (i, j+1) 中的较小值
        //      对于 (i+1, j) ，因为最开始已经将所有 (i, 0) 放入，只需要放入 (i, j+1) 即可
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (ans.size() < k && !queue.isEmpty()) {
            int[] arr = queue.poll();
            ans.add(Arrays.asList(nums1[arr[0]], nums2[arr[1]]));
            if (arr[1] + 1 < n) {
                queue.offer(new int[]{arr[0], arr[1] + 1});
            }
        }
        return ans;
    }
}
