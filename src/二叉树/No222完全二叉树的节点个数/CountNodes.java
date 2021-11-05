package 二叉树.No222完全二叉树的节点个数;

import 二叉树.TreeNode;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
