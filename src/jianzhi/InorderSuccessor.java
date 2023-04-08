package jianzhi;

import jianzhi.common.TreeNode;

public class InorderSuccessor {

    int find = -1;
    TreeNode target = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        scan(root, p);
        return target;
    }

    private void scan(TreeNode root, TreeNode p) {
        if (root == null || find == 1) {
            return ;
        }
        if (p.val < root.val) {
            scan(root.left, p);
        }
        int val = root.val;
        if (find == 0) {
            target = root;
            find = 1;
            return;
        }
        if  (val == p.val) {
            find = 0;
        }
        scan(root.right, p);
    }
}
