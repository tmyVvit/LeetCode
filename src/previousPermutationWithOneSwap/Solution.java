package previousPermutationWithOneSwap;

public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int left = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        if (left == -1) {
            return arr;
        }

        int max = 0;
        int idx = 0;
        for (int j = left + 1; j < arr.length; j++) {
            if (arr[j] < arr[left]) {
                if (arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }
        }

        int tmp = arr[left];
        arr[left] = arr[idx];
        arr[idx] = tmp;
        return arr;
    }
}
