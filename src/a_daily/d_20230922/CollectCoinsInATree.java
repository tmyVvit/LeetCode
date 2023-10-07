package a_daily.d_20230922;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/collect-coins-in-a-tree/description/?envType=daily-question&envId=2023-09-21
public class CollectCoinsInATree {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;

        int[] degree = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            graph[e1].add(e2);
            graph[e2].add(e1);
            degree[e1]++;
            degree[e2]++;
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (coins[i] == 0 && degree[i] == 1) {
                q.push(i);
            }
        }

        int leftEdge = n - 1;
        while (!q.isEmpty()) {
            int i = q.poll();
            leftEdge--;
            for (int b : graph[i]) {
                degree[b]--;
                if (degree[b] == 1 && coins[b] == 0) {
                    q.push(b);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 1) {
                q.push(i);
            }
        }
        leftEdge -= q.size();

        while (!q.isEmpty()) {
            int i = q.poll();
            for (int b : graph[i]) {
                degree[b]--;
                if (degree[b] == 1) {
                    leftEdge--;
                }
            }
        }

        return Math.max(0, leftEdge << 1);
    }
}
