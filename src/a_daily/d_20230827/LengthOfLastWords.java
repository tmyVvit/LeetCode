package a_daily.d_20230827;

// https://leetcode.cn/problems/length-of-last-word/description/
public class LengthOfLastWords {
    public int lengthOfLastWord(String s) {
        String lastWord = "";

        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i;
                while (j < len && s.charAt(j) != ' ') {
                    j++;
                }
                lastWord = s.substring(i, j);
                i = j;
            }
        }
        return lastWord.length();
    }
}
