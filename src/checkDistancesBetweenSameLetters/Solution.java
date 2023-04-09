package checkDistancesBetweenSameLetters;

import java.util.Arrays;

public class Solution {

    public boolean checkDistances(String s, int[] distance) {
        int[] index = new int[26];
        Arrays.fill(index, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (index[idx] == -1) {
                index[idx] = i;
            } else {
                int dis = i - index[idx] - 1;
                if (distance[idx] != dis) {
                    return false;
                }
            }
        }
        return true;

    }

}
