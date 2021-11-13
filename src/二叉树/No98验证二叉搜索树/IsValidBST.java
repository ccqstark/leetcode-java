package 二叉树.No98验证二叉搜索树;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    /**
     * 普通做法，利用中序遍历转换为数组后判断数组是否是单调递增即可
     */
    public boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    /**
     * 在中序遍历递归中顺便判断了单调性，pre指向上一个节点
     */
    private TreeNode pre = null;

    public boolean isValidBST2(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        // 如果前一个节点不为空且大于等于本节点，说明不是单调递增（二叉搜索树中不允许出现重复元素）
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        // 当前节点赋值为前节点
        pre = root;
        boolean right = isValidBST(root.right);

        // 左右子树都符合条件才能判断本节点为root的树符合条件
        return left && right;
    }


}
