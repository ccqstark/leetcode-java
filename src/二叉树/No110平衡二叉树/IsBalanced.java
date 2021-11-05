package 二叉树.No110平衡二叉树;

import 二叉树.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        // -1表示发现了不平衡的二叉树
        return getDepth(root) == -1 ? false : true;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左右子树的高度，得到-1直接返回，表示发现了不平衡的二叉树
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        // 比较左右子树高度差绝对值，不平衡返回-1，否则返回较大的那个+1表示以本节点作为根节点的树的高度
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
