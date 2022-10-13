package relativeRanks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        Map<Integer, Integer> score2Index = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            score2Index.put(score[i], i);
        }
        Arrays.sort(score);
        for (int i = score.length - 1; i >= 0; i--) {
            int rank = score.length - i;
            if  (rank == 1) {
                result[score2Index.get(score[i])] = "Gold Medal";
            } else if (rank == 2) {
                result[score2Index.get(score[i])] = "Silver Medal";
            } else if (rank == 3) {
                result[score2Index.get(score[i])] = "Bronze Medal";
            } else {
                result[score2Index.get(score[i])] = "" + rank;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] scores = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(s.findRelativeRanks(scores)));
    }

}
