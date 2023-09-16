package a_daily.d_20230910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/course-schedule-ii/
public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII test = new CourseScheduleII();
        int[][] pre = {{1,0}};
        int[] res = test.findOrder(2, pre);
        System.out.println(res);
    }
    private int[] result;
    private int idx = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[numCourses];
        result = new int[numCourses];
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0], k -> new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, visited, map)) {
                return new int[0];
            }
        }
        return result;
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
        result[idx++] = course;
        visited[course] = 2;
        return true;
    }
}
