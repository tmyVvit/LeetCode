package buildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> buildArray(int[] target, int n) {
        int i = 1;
        String PUSH = "Push";
        String POP = "Pop";
        List<String> res = new ArrayList<>();
        for (int k : target) {
            if (i == k) {
                res.add(PUSH);
            } else {
                while (i != k) {
                    i++;
                    res.add(PUSH);
                    res.add(POP);
                }
                res.add(PUSH);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildArray(new int[]{1, 2}, 4));
    }

}
