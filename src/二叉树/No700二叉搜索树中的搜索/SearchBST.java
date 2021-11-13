package 二叉树.No700二叉搜索树中的搜索;

import 二叉树.TreeNode;

/**
 * @author ccqstark
 * @description 二叉搜索树的遍历
 * @date 2021/11/13 10:10
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        // 节点为空或者找到了目标值
        if (root == null || root.val == val) {
            return root;
        }

        // 如果目标值小于当前节点值就搜索左子树，大于就搜索右子树
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }

        return null;
    }
}
