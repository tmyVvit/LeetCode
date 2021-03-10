package Huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int totalCount = sc.nextInt();
            while (totalCount-- > 0) {
                int machineCount = sc.nextInt();
                int[][] machine = new int[machineCount][2];
                for (int i = 0; i < machineCount; i++) {
                    machine[i][0] = sc.nextInt();
                    machine[i][1] = sc.nextInt();
                }
                System.out.println(calculateBestSchedule(machine));
            }
        }
    }

    public static int calculateBestSchedule(int[][] machines) {
        Arrays.sort(machines, (a, b) -> b[1] - a[1]);
        int totalTime = 0, start = 0;
        for (int[] machine : machines) {
            start += machine[0];
            totalTime = Math.max(totalTime, start + machine[1]);
        }
        return totalTime;
    }
}
