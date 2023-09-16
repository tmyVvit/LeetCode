package a_daily.d_20230914;

import common.TreeNode;

// https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
public class MaxDiffBetweenNodeAndAncestor {
    int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        find(root);
        return max;
    }

    private int find(TreeNode node, int mi, int ma) {
        if (node == null) {
            return 0;
        }

        int diff = Math.max(Math.abs(node.val - mi), Math.abs(node.val - ma));
        mi = Math.min(node.val, mi);
        ma = Math.max(node.val, ma);
        diff = Math.max(diff, find(node.left, mi, ma));
        diff = Math.max(diff, find(node.right, mi, ma));
        return diff;
    }

    private int[] find(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        }
        if (node.left == null) {
            int[] right = find(node.right);
            int[] res = new int[]{Math.min(right[0], node.val), Math.max(right[1], node.val)};
            max = Math.max(max, Math.max(Math.abs(node.val - right[0]), Math.abs(node.val - right[1])));
            return res;
        }
        if (node.right == null) {
            int[] left = find(node.left);
            int[] res = new int[]{Math.min(left[0], node.val), Math.max(left[1], node.val)};
            max = Math.max(max, Math.max(Math.abs(node.val - left[0]), Math.abs(node.val - left[1])));
            return res;
        }

        int[] l = find(node.left);
        int[] r = find(node.right);
        int mi = Math.min(l[0], r[0]);
        int ma = Math.max(l[1], r[1]);

        max = Math.max(max, Math.max(Math.abs(node.val - mi), Math.abs(node.val - ma)));

        return new int[]{Math.min(node.val, mi), Math.max(node.val, ma)};
    }
}
