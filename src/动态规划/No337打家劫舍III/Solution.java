package 动态规划.No337打家劫舍III;

import 二叉树.TreeNode;

import java.util.HashMap;

/**
 * @author ccqstark
 * @description 两种都是后序遍历
 * @date 2021/12/27 19:13
 */
public class Solution {
    // 用于存储之前计算过的结果
    HashMap<TreeNode, Integer> hashMap = new HashMap<>();

    /**
     * 记忆化递归法（直接递归会超时）
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 如果之前计算过就可以直接返回了
        if (hashMap.containsKey(root)) {
            return hashMap.get(root);
        }
        // 要偷此root节点（左右子节点不可以偷）
        int val1 = root.val;
        if (root.left != null) {
            // 考虑左孙节点
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            // 考虑右孙节点
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷此root节点（左右子节点可以偷了）
        int val2 = rob(root.left) + rob(root.right);

        int result = Math.max(val1, val2);
        // 记得记录一下
        hashMap.put(root, result);
        return result;
    }


    /**
     * 树形动态规划法（更优）
     */
    public int rob2(TreeNode root) {
        int[] res = robTree(root);
        // 最后拿到根节点的偷与不偷数组，求个max就是答案了
        return Math.max(res[0], res[1]);
    }

    public int[] robTree(TreeNode cur) {

        if (cur == null) {
            return new int[]{0, 0};
        }
        // 获取左右子树的偷与不偷数组
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        // 不偷cur，即左子树与右子树各自偷与不偷的最大值相加的和
        int val1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷cur，就是本节点加上左右子树不偷的收获
        int val2 = cur.val + left[0] + right[0];

        // 这个数组val1表示不偷这个点的最大收获，val2表示偷这个点的最大收获
        return new int[]{val1, val2};
    }

}
