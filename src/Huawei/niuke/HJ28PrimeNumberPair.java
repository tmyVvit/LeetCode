package Huawei.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ28PrimeNumberPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            int[] numbers = new int[count];
            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                numbers[i] = sc.nextInt();
                if ((numbers[i] & 1) == 1) {
                    odds.add(numbers[i]);
                } else {
                    evens.add(numbers[i]);
                }
            }

            int[] matches = new int[evens.size()];
            int res = 0;
            for (Integer odd : odds) {
                int[] used = new int[evens.size()];
                if (findMostPrimePair(odd, evens, used, matches)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean findMostPrimePair(int odd, List<Integer> evens, int[] used, int[] matches) {

        for (int i = 0; i < evens.size(); i++) {
            if (used[i] == 0 && isPrime(odd + evens.get(i))) {
                used[i] = 1;
                // 先到先得
                // 如果这个已经被匹配到了，查看之前匹配到的那个奇数还能不能匹配别的偶数
                if (matches[i] == 0 || findMostPrimePair(matches[i], evens, used, matches)) {
                    matches[i] = odd;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int num) {
        if (num == 1) return true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
