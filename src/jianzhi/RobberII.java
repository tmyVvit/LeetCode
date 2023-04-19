package jianzhi;

public class RobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int rob = 0, nrob = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = nums[i] + nrob;
            nrob = Math.max(nrob, rob);
            rob = tmp;
        }

        int rob1 = 0, nrob1 = 0;
        for (int i = 1; i < nums.length ; i++) {
            int tmp = nums[i] + nrob1;
            nrob1 = Math.max(nrob1, rob1);
            rob1 = tmp;
        }

        return Math.max(Math.max(rob, nrob), Math.max(rob1, nrob1));

    }
}
