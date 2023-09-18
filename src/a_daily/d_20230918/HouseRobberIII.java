package a_daily.d_20230918;

import common.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] doRob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] l = doRob(node.left);
        int[] r = doRob(node.right);

        int r1 = l[0] + r[0];
        int r0 = Math.max(node.val + l[1] + r[1], r1);
        return new int[]{r0, r1};
    }
}
