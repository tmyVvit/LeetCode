package a_daily.d_20231206;

import java.util.ArrayList;
import java.util.List;

public class MinTotalPriceOfTrip {
    public static void main(String[] args) {
        MinTotalPriceOfTrip s = new MinTotalPriceOfTrip();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}};
        int[] price = new int[]{2, 2, 10, 6};
        int[][] trips = new int[][]{{0, 2}, {2, 1}, {2, 3}};

        int min = s.minimumTotalPrice(4, edges, price, trips);
        System.out.println(min);

    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        int[] freq = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] trip : trips) {
            dfs(trip[0], -1, trip[1], graph, freq);
        }
        int[] res = dp(0, -1, graph, price, freq);
        return Math.min(res[0], res[1]);

    }

    private int[] dp(int i, int parent, List<Integer>[] graph, int[] price, int[] freq) {
        int common = price[i] * freq[i];
        int half = common / 2;
        for (int n : graph[i]) {
            if (n != parent) {
                int[] res = dp(n, i, graph, price, freq);
                half += res[0];
                common += Math.min(res[0], res[1]);
            }
        }
        return new int[]{common, half};
    }

    private boolean dfs(int from, int parent, int to, List<Integer>[] graph, int[] freq) {
        if (from == to) {
            freq[to]++;
            return true;
        }
        List<Integer> next = graph[from];
        for (int n : next) {
            if (n != parent && dfs(n, from, to, graph, freq)) {
                freq[from]++;
                return true;
            }
        }
        return false;
    }
}
