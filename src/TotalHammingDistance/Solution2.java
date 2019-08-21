package TotalHammingDistance;

// this solution calculate the hamming distance of each bit of each num in nums array.
public class Solution2 {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i & 1);
            }
            // for n-size array in which has only 1-bit integer, and m of which are 1s the other are 0s;
            // the total hamming distance is m * (n - m)
            // e.g. array have 5 values [0,0,1,1,1]
            // the total hamming distance is 6
            total += count * (nums.length - count);
        }
        return total;
    }
}
