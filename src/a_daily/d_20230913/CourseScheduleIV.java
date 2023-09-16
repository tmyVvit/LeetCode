package a_daily.d_20230913;

import java.util.*;

// https://leetcode-cn.com/problems/course-schedule-iv/
public class CourseScheduleIV {
    static Set<Integer> empty = new HashSet<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // int[][] graph = new int[numCourses][numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();


        for (int[] each : prerequisites) {
            //graph[each[1]][each[0]] = 1;
            map.computeIfAbsent(each[1], k -> new HashSet<>());
            map.get(each[1]).add(each[0]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses;i++) {
            dfs(visited, i, map);
        }


        List<Boolean> result = new ArrayList<>();
        for (int[] each : queries) {
            //result.add(graph[each[1]][each[0]] == 1);
            result.add(map.getOrDefault(each[1], empty).contains(each[0]));
        }
        return result;
    }

    private Set<Integer> dfs(int[] visited, int s, Map<Integer, Set<Integer>> map) {
        if (visited[s] == 1) {
            return map.getOrDefault(s, empty);
        }
        Set<Integer> pres = map.getOrDefault(s, empty);
        Set<Integer> reach = new HashSet<>(pres);
        for (int pre : pres) {
            reach.addAll(dfs(visited, pre, map));
        }
        map.put(s, reach);
        visited[s] = 1;
        return reach;
    }
}
