package findAndReplaceInString;

import java.util.Arrays;
import java.util.Comparator;

// 833. 字符串中的查找与替换 https://leetcode.cn/problems/find-and-replace-in-string/
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));

    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        Tuple<Integer, String, String>[] tuples = new Tuple[k];
        for (int i = 0; i < k; i++) {
            tuples[i] = new Tuple<>(indices[i], sources[i], targets[i]);
        }

        Arrays.sort(tuples, Comparator.comparingInt(t -> t.l));
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int i = 0;

        while (i < s.length() && idx < tuples.length) {
            while (i < s.length() && i < tuples[idx].l) {
                sb.append(s.charAt(i));
                i++;
            }
            if (i >= s.length()) {
                break;
            }
            if (i == tuples[idx].l) {
                String src = tuples[idx].m;
                String t = tuples[idx].r;
                int len = src.length();
                boolean match = true;
                for (int j = 0; j < len; j++) {
                    if (i + j >= s.length()
                            || s.charAt(i + j) != src.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.append(t);
                    i = i + len;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            idx++;
        }

        if (i < s.length()) {
            sb.append(s.substring(i));
        }

        return sb.toString();
    }

    static class Tuple<T,R,U> {
        T l;
        R m;
        U r;

        Tuple(T t, R r, U u) {
            this.l = t;
            this.m = r;
            this.r = u;
        }
    }
}
