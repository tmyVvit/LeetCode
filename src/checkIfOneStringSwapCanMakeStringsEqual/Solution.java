package checkIfOneStringSwapCanMakeStringsEqual;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() < 2) return false;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) continue;
            if (idx1 == -1) {
                idx1 = i;
            } else if (idx2 == -1) {
                idx2 = i;
            } else {
                return false;
            }
        }
        if (idx1 > -1 && idx2 > -1) {
            return s1.charAt(idx1) == s2.charAt(idx2)
                    && s1.charAt(idx2) == s2.charAt(idx1);
        }
        return false;
    }
}
