package 二叉树.No145二叉树的后序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}

