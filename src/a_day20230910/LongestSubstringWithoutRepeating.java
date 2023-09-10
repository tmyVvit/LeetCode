package a_day20230910;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        map.put(s.charAt(0), 0);
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}
