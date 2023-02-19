package longestPalindromicSubstring;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.longestPalindrome2("babad"));
//        System.out.println(s.longestPalindrome2("cbbd"));
//        System.out.println(s.longestPalindrome2("bb"));
        System.out.println(s.longestPalindrome2("ac"));

    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        // j < i      --> false
        // j == i     --> true
        // j - i == 1 --> s[i] == s[j] ? true : false
        // j - i > 1  --> dp[i+1][j-1] && s[i] == s[j]

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                boolean same = s.charAt(i) == s.charAt(j);
                if (j == i + 1) {
                    dp[i][j] = same;
                } else {
                    dp[i][j] = same && dp[i + 1][j - 1];
                }
            }
        }
        int max = -1, left = -1, right = -1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findPalindrome(s, i, i);
            int len2 = findPalindrome(s, i, i + 1);

            int maxLen = Math.max(len1, len2);
            if (maxLen > right - left + 1) {
                left = i - (maxLen - 1) / 2;
                right = i + maxLen / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    private int findPalindrome(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }
        return len;
    }
}
