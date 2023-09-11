package a_day20230911;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/course-schedule-iii/
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int total = 0;
        for (int[] course: courses) {
            int t = course[0], d = course[1];
            if (total + t <= d) {
                total += t;
                pq.offer(t);
            } else if (!pq.isEmpty() && pq.peek() > t) {
                int max = pq.poll();
                total = (total - max + t);
                pq.offer(t);
            }
        }
        return pq.size();
    }
}
