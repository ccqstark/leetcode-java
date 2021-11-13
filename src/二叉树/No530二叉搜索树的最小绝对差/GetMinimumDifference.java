package 二叉树.No530二叉搜索树的最小绝对差;

import 二叉树.TreeNode;

/**
 * @author ccqstark
 * @description 整体来说还是二叉搜索树遍历的那个模版
 * @date 2021/11/13 11:30
 */
public class GetMinimumDifference {
    private TreeNode pre = null;
    private Integer minValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 遍历左子树
        getMinimumDifference(root.left);

        // 递增顺序相邻节点判断差是否最小
        if (pre != null && Math.abs(pre.val - root.val) < minValue) {
            minValue = Math.abs(pre.val - root.val);
        }
        pre = root;

        // 遍历右子树
        getMinimumDifference(root.right);

        return minValue;
    }

}
