package leetcode.editor.cn;

// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//  注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-window-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring substring = new MinimumWindowSubstring();
        System.out.println(substring.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE, tlen = t.length();
        // 两个数组分别记录 t 字符串中需要的各个字符数量
        int[] need = new int[128];
        // 窗口中已有的各个字符数量
        int[] have = new int[128];
        int l = -1, r = -1;
        for (int i = 0; i < tlen; i++) {
            need[t.charAt(i)]++;
        }
        // 首先开始的位置必然是 t 中的某个字符
        for (int i = 0; i < s.length(); i++) {
            if (need[s.charAt(i)] > 0) {
                l = r = i;
                break;
            }
        }
        // s 中并不包含任何 t 中的字符
        if (l == -1) return "";
        // count表示窗口中的合法字符的个数，
        // 使用count计数则不需要每次比较窗口中的字符和t中的字符
        int start = l, count = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            // 当前字符不是 t 中的字符时，直接后移
            if (need[cur] == 0) {
                r++;
                continue;
            }
            // 窗口中的字符 + 1
            have[cur]++;
            // 如果窗口中的字符数量小于等于t中的字符数量，则count需要减一
            if (have[cur] <= need[cur]) {
                count++;
            }

            // count == tlen 则说明当前窗口包含了所有 t 中的字符
            while (count == tlen) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                }

                // 试图将左指针右移
                char left = s.charAt(l);
                l++;
                if (need[left] == 0) {
                    continue;
                }
                // 如果窗口中当前字符数大于 t 中字符数，说明右移后的窗口仍然满足情况
                if (have[left] > need[left]) {
                    have[left]--;
                } else if (have[left] == need[left]) {
                    have[left]--;
                    count--;
                }
            }

            r++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);

    }
}
