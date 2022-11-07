package numberOfStudentsUnableToEatLunch;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        int sIdx = 0;
        int[] count = new int[2];
        Set<Integer> eat = new HashSet<>();

        for (int student : students) {
            count[student]++;
        }

        int idx = 0;
        while (sIdx < len) {
            if (eat.size() == len) break;
            ;
            if (!eat.contains(idx)) {
                if (count[sandwiches[sIdx]] == 0) break;
                if (students[idx] == sandwiches[sIdx]) {
                    count[sandwiches[sIdx]]--;
                    sIdx++;
                    eat.add(idx);
                }
            }
            idx = (idx + 1) % len;
        }

        return len - eat.size();
    }

    // 和学生的位置没关系
    public int countStudents2(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        for (int student : students) {
            count[student]++;
        }

        for (int sandwich : sandwiches) {
            if (count[sandwich] > 0) {
                count[sandwich]--;
            } else {
                break;
            }
        }
        return count[0] + count[1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(0^1);
        System.out.println(0^0);
    }


}
