package jianzhi;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentNumber {

    // 根据堆排序的思想
    // 首先遍历一边，找到所有数字 uniq 及每个数字出现的次数
    // 创建一个长度为 uniq.length - k 的大顶堆
    // 剩余的数与堆顶元素比较
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] uniq = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            uniq[i++] = num;
        }

        if (map.size() == k) {
            return uniq;
        }

        int[] heap = new int[map.size() - k];
        for (i = 0; i < heap.length; i++) {
            heap[i] = uniq[i];
        }

        for (int j = heap.length - 1; j >= 0; j--) {
            down(heap, j, map);
        }

        int[] ans = new int[k];
        int idx = 0;
        for (;i < uniq.length; i++) {
            if (map.get(uniq[i]) >= map.get(heap[0])) {
                ans[idx++] = uniq[i];
            } else {
                ans[idx++] = heap[0];
                heap[0] = uniq[i];
                down(heap, 0, map);
            }
        }
        return ans;

    }

    private void down(int[] heap, int i, Map<Integer, Integer> map) {
        int l = 2 * i + 1;
        while (l < heap.length) {
            l = l + 1 < heap.length ? (map.get(heap[l + 1]) > map.get(heap[l]) ? l + 1 : l): l;
            if (map.get(heap[i]) < map.get(heap[l])) {
                swap(heap, i, l);
                i = l;
                l = 2 * i + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
