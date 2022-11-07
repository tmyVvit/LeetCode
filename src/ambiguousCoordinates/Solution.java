package ambiguousCoordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] arsg) {
        Solution s = new Solution();
        System.out.println(s.ambiguousCoordinates("(123)"));
        System.out.println(s.ambiguousCoordinates("(00011)"));
        System.out.println(s.ambiguousCoordinates("(0123)"));
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        // (12)
        for (int i = 2; i <= s.length() - 2; i++) {
            String first = s.substring(1, i);
            String second = s.substring(i, s.length() - 1);

            int firstLimit = first.charAt(0) == '0' ? 1 : first.length();
            int secondLimit = second.charAt(0) == '0' ? 1 : second.length();


            for (int j = 1; j <= firstLimit; j++) {
                String l = addPoint(first, j);
                if (l == null) continue;
                for (int k = 1; k <= secondLimit; k++) {
                    String r = addPoint(second, k);
                    if (r == null) continue;
                    result.add(String.format("(%s, %s)", l, r));
                }
            }
        }
        return result;
    }

    private String addPoint(String str, int index) {
        if (index == str.length()) return str;
        String left = str.substring(0, index);
        String right = str.substring(index);
        if (endWithZero(right)) return null;
        return left + "." + right;
    }

    private boolean endWithZero(String val) {
        return val.charAt(val.length() - 1) == '0';
    }
}
