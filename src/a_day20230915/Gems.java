package a_day20230915;

// https://leetcode.cn/problems/WHnhjV/?envType=daily-question&envId=2023-09-15
public class Gems {

    public static void main(String[] args) {
        int[] gem = new int[]{100, 0, 50, 100};
        int[][] ops = new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}};
        Gems test = new Gems();
        int res = test.giveGem(gem, ops);
        System.out.println(res);
    }
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            transfer(gem, op);
        }
        int min = Integer.MAX_VALUE, max = 0;
        for (int g : gem) {
            min = Math.min(min, g);
            max = Math.max(max, g);
        }
        return max - min;
    }

    private void transfer(int[] gem, int[] operation) {
        int x = operation[0];
        int y = operation[1];

        int gems = gem[x] / 2;
        gem[x] -= gems;
        gem[y] += gems;
    }
}
