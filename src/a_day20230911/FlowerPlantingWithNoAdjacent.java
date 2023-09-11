package a_day20230911;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> neighber = new HashMap<>();
        for (int[] path : paths) {
            int l1 = path[0] - 1, l2 = path[1] - 1;
            neighber.computeIfAbsent(l1, k -> new HashSet<>());
            neighber.computeIfAbsent(l2, k -> new HashSet<>());
            neighber.get(l1).add(l2);
            neighber.get(l2).add(l1);
        }

        Map<Integer, Integer> color = new HashMap<>();

        int[] result = new int[n];
        result[0] = 1;
        color.put(0, 1);

        for (int i = 1; i < n; i++) {
            int[] c = new int[5];
            if (neighber.containsKey(i)) {
                for (int nb : neighber.get(i)) {
                    if (color.containsKey(nb)) {
                        c[color.get(nb)] = 1;

                    }
                }
                for (int j = 1; j <= 4; j++) {
                    if (c[j] == 0) {
                        result[i] = j;
                        color.put(i, j);
                    }
                }

            } else {
                result[i] = 1;
            }
        }
        return result;

    }
}
