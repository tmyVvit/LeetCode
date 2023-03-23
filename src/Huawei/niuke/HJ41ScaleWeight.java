package Huawei.niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ41ScaleWeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int len = sc.nextInt();

            int[] weights = new int[len];
            int[] count = new int[len];
            for (int i = 0; i < len; i++) {
                weights[i] = sc.nextInt();
            }

            for (int i = 0; i < len; i++) {
                count[i] = sc.nextInt();
            }

            System.out.println(totalNumber0(weights, count));
        }

    }


    private static int totalNumber(int[] weight, int[] count) {
        Set<Integer> set = new HashSet<>();
        totalNumber(weight, count, 0, 0, set);
        return set.size();
    }

    private static void totalNumber(int[] weight, int[] count, int index, int sum, Set<Integer> set) {
        if (index == weight.length) {
            set.add(sum);
            return ;
        }

        int maxCount = count[index];

        for (int i = 0; i <= maxCount; i++) {
            int number =  weight[index] * i;
            totalNumber(weight, count, index + 1, sum + number, set);
            System.out.println("index: " + index + ", weight: " + weight[index] + ", count: " + i);
        }
    }

    private static int totalNumber0(int[] weight, int[] count) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                Set<Integer> tmp = new HashSet<>(set);
                for (int n : tmp) {
                    set.add(weight[i] + n);
                }
            }
        }

        return set.size();
    }
}
