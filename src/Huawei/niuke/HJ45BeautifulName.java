package Huawei.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ45BeautifulName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println(max(sc.next()));
            }
        }
    }

    private static int max(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                list.add(arr[i]);
            }
        }

        list.sort((c1, c2) -> Integer.compare(c2, c1));
        int score = 26;
        int res = 0;
        for (int n : list) {
            res += score * n;
            score--;
        }
        return res;
    }
}
