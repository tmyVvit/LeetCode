package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

// using recursive
public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        String path = "";
        List<String> allPaths = new ArrayList<>();

        findPath(allPaths, root, path);
        return allPaths;
    }

    private void findPath(List<String> paths, TreeNode node, String path) {
        if (node == null) return;
        path += (node.val + "->");
        if (node.left == null && node.right == null) {
            paths.add(path.substring(0, path.length() - 2));
            return;
        }
        findPath(paths, node.left, path);
        findPath(paths, node.right, path);
    }
}
