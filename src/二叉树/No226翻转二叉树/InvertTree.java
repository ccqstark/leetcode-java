package 二叉树.No226翻转二叉树;

import 二叉树.TreeNode;

public class InvertTree {

    // 递归法
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        swapNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapNode(TreeNode root){
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

}
