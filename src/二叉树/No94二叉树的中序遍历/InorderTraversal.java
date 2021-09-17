package 二叉树.No94二叉树的中序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

