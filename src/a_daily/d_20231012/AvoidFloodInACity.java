package a_daily.d_20231012;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInACity {

    public static void main(String[] args) {
        int[] rains = new int[]{1, 0, 2,0, 3,0, 2,0,0,0, 1, 2, 3};
        int[] result = new AvoidFloodInACity().avoidFlood(rains);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> lakes = new HashMap<>();

        TreeSet<Integer> left = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int rainLake = rains[i];
            ans[i] = 1;
            if (rainLake == 0) {
                left.add(i);
            } else {
                ans[i] = -1;

                if (lakes.containsKey(rainLake)) {
                    int rainDay = lakes.get(rainLake);
                    if (left.ceiling(rainDay) == null) {
                        return new int[0];
                    }
                    int removeDay = left.ceiling(rainDay);
                    ans[removeDay] = rainLake;
                    left.remove(removeDay);
                }
                lakes.put(rainLake, i);
            }
        }
        return ans;
    }
}
