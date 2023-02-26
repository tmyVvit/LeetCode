package houseRobberIII;

public class Solution {
    public int rob(TreeNode root) {
        int[] res = robber(root);
        return Math.max(res[0], res[1]);
    }

    // result[0] 偷当前节点
    // result[1] 不偷
    int[] robber(TreeNode node) {
        int[] result = new int[2];
        if (node == null) {
            return result;
        }
        int[] left = robber(node.left);
        int[] right = robber(node.right);

        result[0] = node.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
