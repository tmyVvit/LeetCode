package Huawei.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ89Calculate24 {

    private static final Map<String, Integer> map = new HashMap<>();

    private static final char[] operators = new char[]{'+', '-', '*', '/'};

    static {
        map.put("A", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("joker", -1);
        map.put("JOKER", -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] nums = new String[4];

            boolean error = false;
            for (int i = 0; i < 4; i++) {
                nums[i] = sc.next();
                if (map.get(nums[i]) == -1) {
                    System.out.println("ERROR");
                    error = true;
                    break;
                }
            }

            if (error) {
                continue;
            }

            if (!backtrack(nums, new int[nums.length], 0, new String[4])) {
                System.out.println("NONE");
            }
        }
    }

    private static boolean backtrack(String[] origin, int[] used, int index, String[] output) {
        if (index == 4) {
            return find(output);
        }

        for (int i = 0; i < origin.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                output[index] = origin[i];
                if (backtrack(origin, used, index + 1, output)) {
                    return true;
                }
                used[i] = 0;
            }
        }
        return false;
    }

    private static boolean find(String[] nums) {
        int[] ops = new int[3];
        ops[0] = 0;
        if (find(nums, 0, map.get(nums[0]), ops)) {
            return true;
        }
        ops[0] = 1;
        if (find(nums, 0, map.get(nums[0]), ops)) {
            return true;

        }
        ops[0] = 2;
        if (find(nums, 0, map.get(nums[0]), ops)) {
            return true;

        }
        ops[0] = 3;
        if (find(nums, 0, map.get(nums[0]), ops)) {
            return true;
        }
        return false;
    }

    private static boolean find(String[] nums, int index, int sum, int[] ops) {
        switch (operators[ops[index]]) {
            case '+': sum += map.get(nums[index+1]); break;
            case '-': sum -= map.get(nums[index+1]); break;
            case '*': sum *= map.get(nums[index+1]); break;
            case '/': sum /= map.get(nums[index+1]); break;
        }

        if (index == 2) {
            if (sum == 24) {
                System.out.printf("%s%s%s%s%s%s%s\n", nums[0], operators[ops[0]], nums[1], operators[ops[1]], nums[2], operators[ops[2]], nums[3]);
                return true;
            }
            return false;
        }

        ops[index + 1] = 0;
        if (find(nums, index + 1, sum, ops)) {
            return true;
        }
        ops[index + 1] = 1;
        if (find(nums, index + 1, sum, ops)) {
            return true;
        }
        ops[index + 1] = 2;
        if (find(nums, index + 1, sum, ops)) {
            return true;
        }
        ops[index + 1] = 3;
        if (find(nums, index + 1, sum, ops)) {
            return true;
        }
        return false;
    }


}
