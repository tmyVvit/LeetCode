package leetcode;

import java.util.ArrayList;
import java.util.List;

//
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//        返回 s 所有可能的分割方案。
public class PalindromePartitioning {
    int[][] flag; // 1 代表是回文， -1 代表不是， 0代表还没有计算
    List<String> ans = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    int len;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        len = s.length();
        flag = new int[len][len];
        dfs(s, 0);
        return res;
    }

    // 深度搜索
    public void dfs(String s, int i) {
        // i == len 代表已经搜索到最后，直接将本次的结果加入最终结果
        if (i == len) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // [0..i] 的回文子串已经加入ans中，现在计算[i+1..n]
        for (int j = i; j < len; j++) {
            if (isPalindrome(s, i, j)) {
                ans.add(s.substring(i, j+1));
                dfs(s, j+1);
                ans.remove(ans.size()-1);
            }
        }

    }

    public boolean isPalindrome(String word, int i, int j) {
        if (flag[i][j] != 0) return flag[i][j] == 1;
        if (i >= j) {
            flag[i][j] = 1;
        } else {
            flag[i][j] = word.charAt(i) == word.charAt(j) && isPalindrome(word, i+1, j-1) ? 1 : -1;
        }
        return flag[i][j] == 1;
    }

}
