package palindromicSubstrings;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("abc"));
        System.out.println(s.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count + len;
    }
}
