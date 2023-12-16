package a_daily.d_20231212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/next-greater-element-iv/submissions/488507045/?envType=daily-question&envId=2023-12-12
public class NextGreaterNumIV {

    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        LinkedList<int[]> s1 = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));


        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peek()[1]) {
                int[] a = queue.poll();
                ans[a[0]] = nums[i];
            }
            while (!s1.isEmpty() && nums[i] > s1.getLast()[1]) {
                queue.offer(s1.removeLast());
            }
            s1.addLast(new int[]{i, nums[i]});
        }
        return ans;
    }


}
