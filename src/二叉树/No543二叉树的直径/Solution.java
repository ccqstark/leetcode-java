package 二叉树.No543二叉树的直径;

import 二叉树.TreeNode;

public class Solution {

    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    public int traverse(TreeNode root) {
        // 空节点返回0
        if (root == null) return 0;
        // 左右路径深度（长度）
        int leftDepth = traverse(root.left);
        int rightDepth = traverse(root.right);
        maxDepth = Math.max(maxDepth, leftDepth + rightDepth);
        // 返回上一层+1是包括上一层连接本层的那条边
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
