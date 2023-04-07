package flowerPlantingWithNoAdjacent;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] paths = {{1,2},{2,3},{3,1}};
        int[] ans = s.gardenNoAdj(3, paths);
        s.print(ans);
    }



    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] ans = new int[n];

        for (int[] path : paths) {
            map.putIfAbsent(path[0], new HashSet<>());
            map.putIfAbsent(path[1], new HashSet<>());
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);

        }

        for (int i = 0; i < n; i++) {
            int[] color = new int[4];

            Set<Integer> set = map.get(i + 1);
            if (set == null) {
                ans[i] = 1;
                continue;
            }

            for (int next : set) {
                if (ans[next - 1] > 0) {
                    color[ans[next - 1] - 1] = 1;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (color[j] == 0) {
                    ans[i] = j + 1;
                    break;
                }
            }

        }

        return ans;
    }


    private void print(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
