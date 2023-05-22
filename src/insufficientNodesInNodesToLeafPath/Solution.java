package insufficientNodesInNodesToLeafPath;

import common.TreeNode;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int val = dfs(root, 0, limit);
        if (val < limit) {
            return null;
        }
        return root;
    }

    private int dfs(TreeNode node, int sum, int limit) {
        sum += node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }


        int l = node.left == null ? limit - 1 : dfs(node.left, sum, limit);
        int r = node.right == null ? limit - 1 : dfs(node.right, sum, limit);

        if (l < limit && r < limit) {
            return limit - 1;
        }

        if (l < limit) {
            node.left = null;
            return r;
        }

        if (r < limit) {
            node.right = null;
            return l;
        }

        return Math.min(l, r);
    }
}
