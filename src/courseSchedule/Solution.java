package courseSchedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            preMap.putIfAbsent(pre[0], new HashSet<>());
            preMap.get(pre[0]).add(pre[1]);
        }
        if (preMap.isEmpty()) {
            return true;
        }

        // 0: 未搜索 1：搜索中 2：完成
        int[] status = new int[numCourses];
        for (int key : preMap.keySet()) {
            if (status[key] == 0) {
                if (!findPre(key, preMap, status)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean findPre(int val, Map<Integer, Set<Integer>> pres, int[] status) {
        if (status[val] == 2) {
            return true;
        }
        if (status[val] == 1) {
            return false;
        }
        if (!pres.containsKey(val)) {
            status[val] = 2;
            return true;
        }
        status[val] = 1;
        Set<Integer> pre = pres.get(val);
        for (int p : pre) {
            if (!findPre(p, pres, status)) {
                return false;
            }
        }
        status[val] = 2;
        return true;
    }
}
