package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("3 : " + s.lengthOfLongestSubstring("abcabcabc"));
        System.out.println("4 : " + s.lengthOfLongestSubstring("abcadbcabc"));
        System.out.println("1 : " + s.lengthOfLongestSubstring("aaa"));
        System.out.println("4 : " + s.lengthOfLongestSubstring("a+- a"));
        System.out.println("1 : " + s.lengthOfLongestSubstring(" "));
        System.out.println("3 : " + s.lengthOfLongestSubstring("aud"));
        System.out.println("4 : " + s.lengthOfLongestSubstring("abcad"));
        System.out.println("3 : " + s.lengthOfLongestSubstring("pwwkew"));

    }

    public static final int LEN = 256;
    public static final char BASE = 0x0;

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int[] map = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            map[i] = -1;
        }


        int longest = 0;
        int start = 0, end = 0;
        while (s.length() - start > longest) {
            map[s.charAt(start) - BASE] = start;

            if (end == start) {
                end = start + 1;
            }
            boolean findRepeat = false;
            for (;end < s.length();end++) {
                int flag = map[s.charAt(end) - BASE];
                if (flag == -1) {
                    map[s.charAt(end) - BASE] = end;
                } else {
                    longest = Math.max(longest, end - start);
                    clearmap(map, flag);
                    start = flag + 1;
                    findRepeat = true;
                    break;
                }
            }
            if (!findRepeat) {
                longest = Math.max(longest, s.length() - start);
                break;
            }
        }
        return longest;
    }



    private void clearmap(int[] map, int mark) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] <= mark) {
                map[i] = -1;
            }
        }

    }
}
