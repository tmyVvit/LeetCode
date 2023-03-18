package jianzhi;

import jianzhi.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftValueInBinaryTree {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        int ans = 0;
        while (!level.isEmpty()) {
            List<TreeNode> current = level;
            level = new ArrayList<>();

            for (TreeNode node : current) {
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            TreeNode node = current.get(0);
            ans = node.val;
        }

        return ans;
    }
}
