package jianzhi;

import jianzhi.common.TreeNode;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
