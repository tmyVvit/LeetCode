package Huawei.shangji;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");

            List<Integer> numbers = new ArrayList<>();
            for(String str : strs) {
                numbers.add(Integer.parseInt(str));
            }

            print(move(numbers));
        }

    }

    private static void print(List<Integer> numbs) {
        if (numbs.size() == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : numbs) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(num);
        }
        System.out.println("[" + sb.toString() + "]");
    }

    private static List<Integer> move(List<Integer> nums) {
        LinkedList<Integer> result = new LinkedList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        for (int num : nums) {
            if (result.isEmpty()) {
                result.addLast(num);
            } else if (num < 0) {
                // -
                while (!result.isEmpty()) {
                    int last = result.getLast();
                    if (last < 0) {
                        result.addLast(num);
                        break;
                    }
                    if (last + num == 0) {
                        result.pollLast();
                        break;
                    } else if (last + num < 0) {
                        result.pollLast();
                    } else if (last + num > 0) {
                        break;
                    }
                    if (result.isEmpty()) {
                        result.addLast(num);
                        break;
                    }
                }
            } else if (num > 0) {
                // +
                result.addLast(num);

            }
        }

        return result;
    }

}
