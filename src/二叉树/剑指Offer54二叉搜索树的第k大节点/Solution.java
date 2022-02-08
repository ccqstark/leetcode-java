package 二叉树.剑指Offer54二叉搜索树的第k大节点;

import 二叉树.TreeNode;

public class Solution {
    int th = 0; // 当前遍历到第几个数
    int ans = 0; // 答案

    public int kthLargest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    /**
     * 中序遍历的倒叙，右中左的顺序，最后得到的是从大到小的序列
     */
    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.right, k);
        if (++th == k) ans = root.val; // 当遇到第k个的是否赋值给ans即可
        traverse(root.left, k);
    }
}
