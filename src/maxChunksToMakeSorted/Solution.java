package maxChunksToMakeSorted;

public class Solution {

    // 当拆分数组最大值 == 下标时，可以拆
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while (i < arr.length && i < curr) {
                i++;
                if (i < arr.length && curr < arr[i]) {
                    curr = arr[i];
                }
            }
            if (i == arr.length) break;
            count++;
        }
        return count;
    }

    // 当拆分数组最大值 == 下标时，可以拆
    public int maxChunksToSorted2(int[] arr) {
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 4, 0, 1, 2};
        // 3,4, 0, 1, 2
        System.out.println(s.maxChunksToSorted(arr));
    }
}
