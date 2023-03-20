package lexicographicallySmallestStringAfterApplyingOperations;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<String> set = new HashSet<>();
    private String min = null;

    public String findLexSmallestString(String s, int a, int b) {
        min = s;
        set.add(s);
        find(s, a, b);
        return min;
    }

    private void find(String s, int a, int b) {
        String add = add(s, a);
        if (!set.contains(add)) {
            min = compare(min, add) == 1 ? add : min;
            set.add(add);
            find(add, a, b);
        }

        String rotate = rotate(s, b);
        if (!set.contains(rotate)) {
            min = compare(min, rotate) == 1 ? rotate : min;
            set.add(rotate);
            find(rotate, a, b);
        }
    }

    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i+=2) {
            char ch = (char) (chars[i] + a);
            if (ch > '9') {
                ch -= 10;
            }
            chars[i] = ch;
        }
        return new String(chars);
    }

    private String rotate(String s, int b) {
        char[] chars = new char[s.length()];
        int l = 0, r = (l + b) % s.length();
        while (l < s.length()) {
            chars[r] = s.charAt(l);
            l++;
            r = (r + 1) % s.length();
        }
        return new String(chars);
    }

    private int compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLexSmallestString("5525", 9, 2));

//        System.out.println(s.add("2151", 9));
    }
}
