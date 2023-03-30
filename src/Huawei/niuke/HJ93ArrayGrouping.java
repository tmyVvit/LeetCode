package Huawei.niuke;

import java.util.Scanner;

public class HJ93ArrayGrouping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();

            int[] nums = new int[count];
            int[] choose = new int[count];
            for (int i = 0; i < count; i++) {
                int num = sc.nextInt();
                nums[i] = num;
                if (num % 5 == 0) {
                    choose[i] = 1;
                } else if (num % 3 == 0) {
                    choose[i] = -1;
                }
            }
            System.out.println(find(nums, choose, 0));
        }
    }

    private static boolean find(int[] nums, int[] choose, int index) {
        if (index == nums.length) {
            int sum0 = 0, sum1 = 0;
            for (int i = 0; i < index; i++) {
                if (choose[i] == 1) {
                    sum0 += nums[i];
                } else {
                    sum1 += nums[i];
                }
            }
            return sum0 == sum1;
        }

        if (choose[index] != 0) {
            return find(nums, choose, index + 1);
        }

        choose[index] = 1;
        if (find(nums, choose, index + 1)) {
            return true;
        }
        choose[index] = -1;
        boolean res =  find(nums, choose, index + 1);
        choose[index] = 0;
        return res;
    }
}
