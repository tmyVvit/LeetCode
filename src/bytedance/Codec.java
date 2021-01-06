package bytedance;

import java.util.ArrayList;
import java.util.List;

// 将二叉树序列化和反序列化
public class Codec {

    public static void main(String[] args) {
        String str = "[1,null,2,3]";
        Codec2 codec = new Codec2();
        TreeNode root = codec.deserialize(str);
        System.out.println(codec.serialize(root));
    }

    /**
     *  这个方法会将二叉树补为一个满二叉树，没有的节点以null代替，十分耗费空间
     *  例如：        1
     *                  2
     *                3
     *  上面这个只有三个节点的二叉树，序列化之后会变为：[1,null,2,null,null,3,null]
     */
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        List<TreeNode> level = new ArrayList<>();
        List<String> vals = new ArrayList<>();
        level.add(root);
        boolean currentLevelHasValue = true;
        while (currentLevelHasValue) {
            currentLevelHasValue = false;
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : level) {
                if (node == null) {
                    vals.add("null");
                    tmp.add(null);tmp.add(null);
                } else {
                    vals.add(String.valueOf(node.val));
                    if (node.left != null || node.right != null) currentLevelHasValue = true;
                    tmp.add(node.left);tmp.add(node.right);
                }
            }
            level = tmp;
        }


        return joinString(vals);
    }

    private String joinString(List<String> vals) {
        StringBuilder sb = new StringBuilder("[");
        for (String s : vals) {
            if (sb.length() != 1) sb.append(",");
            sb.append(s);
        }
        sb.append("]");
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        String[] vals = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        deserialize(vals, 1, root);
        deserialize(vals, 2, root);
        return root;
    }

    private void deserialize(String[] vals, int currNode, TreeNode parentNode) {
        if (currNode >= vals.length || "null".equals(vals[currNode])) return ;
        TreeNode current = new TreeNode(Integer.parseInt(vals[currNode]));
        if (currNode % 2 == 1) {
            parentNode.left = current;
        } else parentNode.right = current;
        deserialize(vals, currNode*2+1, current);
        deserialize(vals, currNode*2+2, current);
    }
}

/**
 *
 *
 *
 */
class Codec2 {
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean notAllNull = true;
        while (notAllNull) {
            List<TreeNode> tmp = new ArrayList<>();
            notAllNull = false;
            for (TreeNode node : level) {
                if (node == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(node.val).append(",");
                    if (node.left != null || node.right != null) notAllNull = true;
                    tmp.add(node.left);tmp.add(node.right);
                }
            }
            level = tmp;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.append("]").toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        String[] vals = data.substring(1, data.length()-1).split(",");
        List<TreeNode> level = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        level.add(root);
        for (int i = 1; i < vals.length; ) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : level) {
                if (node == null) continue;
                TreeNode left = buildNode(i< vals.length? vals[i++]:"null");
                TreeNode right = buildNode(i< vals.length? vals[i++]:"null");
                node.left = left;node.right = right;
                tmp.add(left);tmp.add(right);
            }
            level = tmp;
        }
        return root;
    }

    private TreeNode buildNode(String str) {
        if ("null".equals(str)) return null;
        return new TreeNode(Integer.parseInt(str));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
