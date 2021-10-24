package 二叉树.No100相同的树;

import 二叉树.TreeNode;

public class IsSameTree {
    // 与101题类似
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
        boolean leftsame = compare(left.left, right.left);
        boolean rightsame = compare(left.right, right.right);

        // 左右子树都为对称了才行
        return leftsame && rightsame;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
}
