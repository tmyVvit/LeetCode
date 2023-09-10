package a_day20230910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/course-schedule
public class CourseSchedule {
    public boolean canFinish(int numCoursed, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 0 init, 1 visiting, 2 visited
        int[] visited = new int[numCoursed];

        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0], k -> new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCoursed; i++) {
            if (visited[i] == 0 && !dfs(i, visited, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, int[] visited, Map<Integer, List<Integer>> map) {
        if (visited[course] == 1) return false;
        if (visited[course] == 2) return true;
        visited[course] = 1;
        if (map.containsKey(course)) {
            for (int next : map.get(course)) {
                if (!dfs(next, visited, map)) {
                    return false;
                }
            }
        }
        visited[course] = 2;
        return true;
    }
}
