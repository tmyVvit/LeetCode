package customeSortString;

import java.util.Arrays;

public class Solution {
    public String customSortString(String order, String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int count = counts[ch - 'a'];
            fill(sb, ch, count);
            counts[ch - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            fill(sb, (char) ('a' + i), counts[i]);
        }
        return sb.toString();
    }

    private void fill(StringBuilder sb, char ch, int count) {
        while (count-- > 0) {
            sb.append(ch);
        }
    }
}
