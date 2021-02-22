package bytedance;

import java.util.Arrays;
/*
给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。
例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/living-people-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LivingPeople {
    public int maxAliveYear(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int alive = 0, deathIndex = 0, maxYear = 1899, maxAlive = 0;
        for (int j : birth) {
            alive++;
            while (death[deathIndex] < j) {
                alive--;
                deathIndex++;
            }
            if (alive > maxAlive) {
                maxYear = j;
                maxAlive = alive;
            }
        }
        return maxYear;
    }

    public int maxAliveYear2(int[] birth, int[] death) {
        int[] lives = new int[102];
        for (int i = 0; i < birth.length; i++) {
            lives[birth[i]-1900] ++;
            lives[death[i]-1900+1]--;
        }
        int max = 0, sum = 0, maxYear = 1899;
        for (int i = 0; i < lives.length; i++) {
            sum += lives[i];
            if (sum > max) {
                max = sum;
                maxYear = i + 1900;
            }
        }
        return maxYear;
    }

    public static void main(String[] args) {
        int[] birth = {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901};
        int[] death = {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};

        LivingPeople livingPeople = new LivingPeople();
        livingPeople.maxAliveYear2(birth, death);
    }
}
