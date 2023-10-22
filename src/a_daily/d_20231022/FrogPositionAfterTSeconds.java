package a_daily.d_20231022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrogPositionAfterTSeconds {

    public static void main(String[] args) {
        FrogPositionAfterTSeconds frogPositionAfterTSeconds = new FrogPositionAfterTSeconds();
//        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
//        double result = frogPositionAfterTSeconds.frogPosition(7, edges, 2, 4);
//        System.out.println(result);
        int[][] edges = parse("[[2,1],[3,2]]");
        System.out.println(frogPositionAfterTSeconds.frogPosition(3, edges, 1, 2));
        edges = parse("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9],[9,10],[10,11],[11,12],[12,13],[13,14],[14,15],[15,16],[16,17],[17,18],[1,19],[1,20],[1,21],[1,22],[1,23],[1,24],[1,25],[1,26],[1,27],[1,28],[1,29],[1,30],[1,31],[1,32],[1,33],[1,34],[1,35],[1,36],[2,37],[2,38],[2,39],[2,40],[2,41],[2,42],[2,43],[2,44],[2,45],[2,46],[2,47],[2,48],[2,49],[2,50],[2,51],[2,52],[2,53],[2,54],[3,55],[3,56],[3,57],[3,58],[3,59],[3,60],[3,61],[3,62],[3,63],[3,64],[3,65],[3,66],[3,67],[3,68],[3,69],[3,70],[4,71],[4,72],[4,73],[4,74],[5,75],[5,76],[6,77],[6,78],[7,79],[7,80],[8,81],[8,82],[9,83],[9,84],[10,85],[10,86],[11,87],[11,88],[12,89],[13,90],[14,91],[15,92],[16,93],[17,94]]");
        System.out.println(frogPositionAfterTSeconds.frogPosition(94, edges, 17, 94));

    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[][] map = new int[n + 1][n + 1];
        double[] possibility = new double[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int[] edge : edges) {
            int l = edge[0], r = edge[1];
            map[l][r] = 1;
            map[r][l] = 1;
        }

        List<Integer> next = new ArrayList<>();
        next.add(1);
        possibility[1] = 1;
        while (t-- > 0) {
            List<Integer> tmp = next;
            next = new ArrayList<>();
            for (int current : tmp) {
                visited[current] = true;
                List<Integer> cNext = new ArrayList<>();
                int[] possibleNext = map[current];
                for (int i = 1; i < possibleNext.length; i++) {
                    if (possibleNext[i] == 1 && !visited[i]) {
                        cNext.add(i);
                    }
                }
                if (!cNext.isEmpty()) {
                    for (int i : cNext) {
                         possibility[i] = possibility[current] * (1 / (double) cNext.size());
                    }
                    next.addAll(cNext);
                } else {
                    next.add(current);
                    if (current == target) {
                        return possibility[target];
                    }
                }
            }
        }
        if (next.contains(target)) {
            return possibility[target];
        }
        return 0;
    }

    private static int[][] parse(String line) {
        line = line.substring(2, line.length() - 2);
        String[] split = line.split("],\\[");
        int[][] result = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(",");
            result[i] = new int[split1.length];
            for (int j = 0; j < split1.length; j++) {
                result[i][j] = Integer.parseInt(split1[j]);
            }
        }
        return result;
    }
}
