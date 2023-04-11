package jianzhi;

import java.util.Random;

public class RandomNumWithWeight {

    private final int[] preSum;
    private final int bound;
    private final Random random;

    public RandomNumWithWeight(int[] w) {
        preSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            preSum[i] = sum;
        }
        bound = preSum[w.length - 1];
        random = new Random();
    }

    public int pickIndex() {
        int num = random.nextInt(bound) + 1;
        return findIndex(num);
    }

    private int findIndex(int num) {
        int l = 0, r = preSum.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (preSum[m] > num) {
                r = m;
            } else if (preSum[m] < num){
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
