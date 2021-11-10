package 二叉树.No112路径总和;

import 二叉树.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 用目标值去减到0
        return traversal(root, targetSum - root.val);
    }

    public boolean traversal(TreeNode root, int count) {
        // 到达叶子节点且count为0
        if (root.left == null && root.right == null && count == 0) {
            return true;
        }
        // 到达叶子节点但是count不为0
        if (root.left == null && root.right == null) {
            return false;
        }

        // 如果左子树中存在目标路径
        if (root.left != null && traversal(root.left, count - root.left.val)) {
            return true;
        }
        // 如果右子树中存在目标路径
        if (root.right != null && traversal(root.right, count - root.right.val)) {
            return true;
        }

        return false;
    }
}
