package topKFrequentElements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,2,2,3};
        Solution s = new Solution();
        print(s.topKFrequent(nums, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];
        List<Map.Entry<Integer, Integer>> sorted = count.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = sorted.get(i).getKey();
        }
        return res;
    }

    // 利用小顶堆
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{entry.getKey(),entry.getValue()});
            } else {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
