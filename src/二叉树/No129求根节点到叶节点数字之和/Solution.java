package 二叉树.No129求根节点到叶节点数字之和;

import 二叉树.TreeNode;

// 深度优先，没啥好说
public class Solution {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(0, root);
        return sum;
    }

    public void traverse(int num, TreeNode root) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        traverse(num, root.left);
        traverse(num, root.right);
    }
}
