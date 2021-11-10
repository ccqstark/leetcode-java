package 二叉树.No404左叶子之和;

import 二叉树.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 右子树递归
        int rightValue = sumOfLeftLeaves(root.right);
        int leftValue;

        // 如果左子树就是叶子节点，不需要递归了
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue = root.left.val;
        } else {
            // 不是叶子节点就需要递归
            leftValue = sumOfLeftLeaves(root.left);
        }

        // 返回左右子树的左叶子之和为本节点的左叶子之和
        return leftValue + rightValue;
    }

}
