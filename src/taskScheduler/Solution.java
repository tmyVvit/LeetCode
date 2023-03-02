package taskScheduler;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.leastInterval(new char[]{'a','a','a','b','b','b', 'c','c','c','d','d','e'}, 2));

    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0) + 1;
            max = Math.max(count, max);
            map.put(task, count);
        }
        int maxCount = 0;
        for (int count : map.values()) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }


}
