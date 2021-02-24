package bytedance;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0, len = customers.length;
        for (int i = 0; i < X && i < len; i++) {
            max += customers[i];
        }
        if (X >= len) return max;
        for (int i = X; i < len; i++) {
            max += (grumpy[i] == 0 ? customers[i] : 0);
        }
        int pre = max;
        for (int i = X; i < len; i++) {
            int tmp = pre;
            tmp = tmp - (grumpy[i-X]==0?0:customers[i-X]) + (grumpy[i] == 0 ? 0 : customers[i]);
            max = max > tmp ? max : tmp;
            pre = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner solution = new GrumpyBookstoreOwner();
        int[] customers = {1}, grumpy = {0};
        solution.maxSatisfied(customers, grumpy, 1);
    }
}
