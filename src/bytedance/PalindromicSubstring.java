package bytedance;

public class PalindromicSubstring {
    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome("ababababababa"));
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心的回文子串
            int len1 = expandAroundCenter(s, i, i);
            // 以i和i+1为中心的回文子串
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    // 从中间扩散，向两边寻找
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;right++;
        }
        return right - left - 1;
    }
}
