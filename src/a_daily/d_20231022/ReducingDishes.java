package a_daily.d_20231022;

import java.util.Arrays;

public class ReducingDishes {

    public static void main(String[] args) {
        ReducingDishes reducingDishes = new ReducingDishes();
        int[] array = new int[]{-1,-8,0,5,-9};
        int result = reducingDishes.maxSatisfaction(array);
        System.out.println(result);
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int minIndex = find(satisfaction);
        if (minIndex >= satisfaction.length) {
            return 0;
        }
        int sum = 0;
        int result = 0;
        for (int i = minIndex; i < satisfaction.length; i++) {
            sum += satisfaction[i];
            result += (satisfaction[i] * (i - minIndex + 1));
        }

        int i = minIndex - 1;
        while (i >= 0) {
            sum += satisfaction[i];
            if (sum <= 0) {
                break;
            }
            result += sum;
            i--;
        }
        return result;
    }

    private int find(int[] array) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (array[mid] >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
