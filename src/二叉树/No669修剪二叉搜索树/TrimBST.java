package 二叉树.No669修剪二叉搜索树;

import 二叉树.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null){
            return null;
        }
        // 如果小于上限，则对右子树进行递归，因为右子树中可能还有符合范围的节点
        // 此操作同时也删除了本节点，大于上限同理
        if (root.val < low){
            return trimBST(root.right, low ,high);
        }
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        // 如果本节点符合要求，那么对左右子树递归进行检查
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
