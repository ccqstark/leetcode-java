package 二叉树.No701二叉搜索树中的插入操作;

import 二叉树.TreeNode;

public class InsertIntoBST {
    // 这题是普通的BST插入，不用进行翻转平衡，找到空节点插入即可
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }

        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        }

        if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
