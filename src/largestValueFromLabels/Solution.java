package largestValueFromLabels;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

        int[][] valLabel = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            valLabel[i][0] = values[i];
            valLabel[i][1] = labels[i];
        }

        Arrays.sort(valLabel, (a, b) -> Integer.compare(b[0], a[0]));
        int total = 0, score = 0;
        Map<Integer, Integer> labelCount = new HashMap<>();

        for (int[] val : valLabel) {
            if (total >= numWanted) {
                break;
            }

            int count = labelCount.getOrDefault(val[1], 0);
            if (count < useLimit) {
                score += val[0];
                labelCount.put(val[1], count + 1);
                total++;
            }
        }
        return score;
    }

}
