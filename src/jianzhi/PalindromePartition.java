package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public String[][] partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int[][] cache = new int[s.length()][s.length()];

        backtrack(0, s, new ArrayList<>(), res, cache);
        String[][] result = new String[res.size()][];


        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    private void backtrack(int idx, String s, List<String> partitions, List<List<String>> res, int[][] cache) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i, cache) == 1) {
                partitions.add(s.substring(idx, i + 1));
                backtrack(i + 1, s, partitions, res, cache);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private int isPalindrome(String s, int l, int r, int[][] cache) {
        if (cache[l][r] == 0) {
            if (l >= r) {
                cache[l][r] = 1;
                return cache[l][r];
            } else if (s.charAt(l) == s.charAt(r)) {
                cache[l][r] = isPalindrome(s, l + 1, r - 1, cache);
                return cache[l][r];
            } else {
                cache[l][r] = -1;
            }
        }
        return cache[l][r];
    }

}
