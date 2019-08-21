package TotalHammingDistance;

//  477. Total Hamming Distance
//   The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//   Now your job is to find the total Hamming distance between all pairs of the given numbers.


// this solution is an ugly solution, just traverse the int array twice and get the hamming distance of each pair
// O(n^2) time
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int length = nums.length;
        int total = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }
        }
        return total;
    }

    private int hammingDistance(int x, int y) {
        int and = x ^ y;
        int result = 0;
        while (and != 0) {
            if ((and & 1) == 1) result++;
            and = and >> 1;
        }
        return result;
    }
}
