package fruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalFruit(new int[]{1,2,1}));
        System.out.println(s.totalFruit(new int[]{0,1,2,2}));
        System.out.println(s.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(s.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));

    }

    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        int[] pre = new int[len];
        int start = -1;
        for (int i = 0; i < len; ) {
            pre[i] = i;
            int j = i + 1;
            while (j < len && fruits[j] == fruits[i]) {
                pre[j] = i;
                j++;
            }
            i = j;
            if (start == -1) {
                start = j;
            }
        }
        if (start >= len) return len;
        int[] basket = new int[2];
        int max = -1, curr = start + 1;
        basket[0] = fruits[start - 1];
        basket[1] = fruits[start];

        for (int i = start + 1; i < len; i++) {
            if (basket[0] == fruits[i] || basket[1] == fruits[i]) {
                curr++;
            } else {
                max = Math.max(max, curr);
                if (basket[0] == fruits[i-1]) {
                    basket[1] = fruits[i];
                } else {
                    basket[0] = fruits[i];
                }
                curr = i - pre[i - 1] + 1;
            }
        }
        return Math.max(max, curr);
    }

    public int totalFruit2(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = -1, left = 0, right = 0;
        for (; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
