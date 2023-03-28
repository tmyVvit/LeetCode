package Huawei.niuke;

import java.util.*;

public class HJ25DataClassification {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int iCount = sc.nextInt();
            int[] is = new int[iCount];
            for (int i = 0; i < iCount; i++) {
                is[i] = sc.nextInt();
            }

            int rCount = sc.nextInt();
            Set<Integer> set = new HashSet<>(rCount);
            for (int i = 0; i < rCount; i++) {
                set.add(sc.nextInt());
            }

            List<Integer> rs = new ArrayList<>(set);
            rs.sort(Integer::compare);

            List<Integer> res = new ArrayList<>();
            for (int r : rs) {
                List<Integer> find = new ArrayList<>();
                for (int idx = 0; idx < is.length; idx++) {
                    int i = is[idx];
                    if (intContain(r, i)) {
                        find.add(idx);
                        find.add(i);
                    }
                }

                if (!find.isEmpty()) {
                    res.add(r);
                    res.add(find.size() / 2);
                    res.addAll(find);
                }

            }

            System.out.printf("%d ", res.size());

            for (int num : res) {
                System.out.printf("%d ", num);
            }
        }

    }

    private static boolean intContain(int r, int i) {
        if (r == i) {
            return true;
        }

        if (r > i || r / 10 == i / 10) {
            return false;
        }

        int limit = 10;
        while (limit < i) {
            if (limit > r) {
                break;
            }
            limit *= 10;
        }

        while (i > 0) {
            if (i % limit == r) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
