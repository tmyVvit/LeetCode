package Huawei.niuke;

import java.util.*;

public class HJ68GradeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int count = sc.nextInt();
            int sort = sc.nextInt();

            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < count; i++) {
                String name = sc.next();
                int score = sc.nextInt();

                map.computeIfAbsent(score, k -> new ArrayList<>());
                map.get(score).add(name);
            }

            if (sort == 0) {
                for (int i = 100; i >= 0; i--) {
                    List<String> names = map.get(i);
                    if (names != null) {
                        for (String name : names) {
                            System.out.printf("%s %d\n", name, i);
                        }
                    }
                }
            } else if (sort == 1) {
                for (int i = 0; i <= 100; i++) {
                    List<String> names = map.get(i);
                    if (names != null) {
                        for (String name : names) {
                            System.out.printf("%s %d\n", name, i);
                        }
                    }
                }
            }
        }

    }
}
