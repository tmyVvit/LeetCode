package findAllAnagramsInString;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] arsg) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (p.length() > s.length()) {
            return res;
        }

        int[] target = new int[26];
        int[] current = new int[26];

        int len = p.length();
        for (int i = 0; i < len; i++) {
            char ch = p.charAt(i);
            target[ch - 'a'] = target[ch - 'a'] + 1;
        }

        int start = 0, end = len;
        for (int i = 0; i < end; i++) {
            char ch = s.charAt(i);
            current[ch - 'a'] = current[ch - 'a'] + 1;
        }

        while (end <= s.length()) {
            if (same(current, target)) {
                res.add(start);
            }
            current[s.charAt(start) - 'a'] = current[s.charAt(start) - 'a'] - 1;
            current[s.charAt(end) - 'a'] = current[s.charAt(end) - 'a'] + 1;

            start++;
            end++;
        }

        if (same(current, target)) {
            res.add(start);
        }
        return res;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
