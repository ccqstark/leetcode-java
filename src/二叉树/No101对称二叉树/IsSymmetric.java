package 二叉树.No101对称二叉树;

import 二叉树.TreeNode;

public class IsSymmetric {

    public boolean compare(TreeNode left, TreeNode right) {
        // 左右一半为空的情况
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        // 左右都为空的情况
        if (left == null && right == null) {
            return true;
        }
        // 左右都不为空，但值不相同的情况
        if (left != null && right != null && left.val != right.val) {
            return false;
        }
        // 剩下的就是左右都不为空且值相同的情况，应该进一步向下递归比较
        boolean leftsame = compare(left.left, right.right);  // 比较左子树的左节点，右子树的右节点
        boolean rightsame = compare(left.right, right.left); // 比较左子树的右节点，右子树的左节点

        // 左右子树都为对称了才行
        return leftsame && rightsame;
    }

    // 递归法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

}
