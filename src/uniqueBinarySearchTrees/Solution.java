package uniqueBinarySearchTrees;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numTrees(3));
        System.out.println(s.numTrees(2));
        System.out.println(s.numTrees(1));
    }

    private final int[] cache = new int[20];
    public int numTrees(int n) {
        if (n < 2) {
            return n;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int left = i - 1 == 0 ? 1 : numTrees(i - 1);
            int right = n - i == 0 ? 1 : numTrees(n - i);
            sum += (left * right);
        }

        cache[n] = sum;
        return sum;
    }
}
