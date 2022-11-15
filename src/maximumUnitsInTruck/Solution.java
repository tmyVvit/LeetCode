package maximumUnitsInTruck;

import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int sum = 0;
        for (int[] boxes : boxTypes) {
            if (truckSize > boxes[0]) {
                sum += boxes[0] * boxes[1];
                truckSize -= boxes[0];
            } else {
                sum += truckSize * boxes[1];
                break;
            }
        }
        return sum;
    }
}
