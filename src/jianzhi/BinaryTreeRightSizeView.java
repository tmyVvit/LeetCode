package jianzhi;

import jianzhi.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSizeView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);

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
            TreeNode node = current.get(current.size() - 1);
            res.add(node.val);
        }

        return res;

    }
}
