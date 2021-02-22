package bytedance;

import java.util.*;

/**
 * 最长不重复子串
 */

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            Character ch = s.charAt(end);
            if (!map.containsKey(ch)) {
                map.put(ch, end);
            } else {
                maxLen = Math.max(maxLen, end - start);
                int newStart = map.get(ch) + 1;
                if (end - newStart > newStart - start - 1) {
                    removeMap(map, s, start, newStart-1);
                } else {
                    resetMap(map, s, newStart, end);
                }
                map.put(ch, end);
                start = newStart;
            }
            end++;
        }
        maxLen = Math.max(maxLen, end - start);
        return maxLen;
    }
    void removeMap(Map<Character, Integer> map, String s, int start, int end) {
        for (int i = start; i <= end; i++) {
            map.remove(s.charAt(i));
        }
    }
    void resetMap(Map<Character, Integer> map, String s, int start, int end) {
        map.clear();
        for (int i = start; i <= end; i++) {
            map.put(s.charAt(i), i);
        }
    }
}
