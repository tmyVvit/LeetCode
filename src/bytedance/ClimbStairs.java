package bytedance;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int first = 1, second = 2, nstairs=2;
        for (int i = 3; i < n+1; i++) {
            nstairs = first + second;
            first = second;
            second = nstairs;
        }
        return nstairs;
    }
}
