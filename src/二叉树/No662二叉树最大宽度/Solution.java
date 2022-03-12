package 二叉树.No662二叉树最大宽度;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int maxWidth = 1; // 如果根节点不为null，那至少宽度为1
    List<Integer> rowLeft = new ArrayList<>(); // 用于记录每一层最左的那个节点的位置

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // 根节点为null，那宽度为0
        dfs(root, 0, 1);
        return maxWidth;
    }

    // 深度优先搜索，depth是深度，pos表示节点在当层的位置（从1开始）
    void dfs(TreeNode root, int depth, int pos) {
        if (rowLeft.size() - 1 < depth) rowLeft.add(pos); // 如果是当层遍历到的第一个节点，记录最左位置
        else maxWidth = Math.max(pos - rowLeft.get(depth) + 1, maxWidth); // 如果不是第一个，那计算宽度并取全局最大
        // 左右子树递归
        if (root.left != null) dfs(root.left, depth + 1, (pos - 1) * 2 + 1);
        if (root.right != null) dfs(root.right, depth + 1, (pos - 1) * 2 + 2);
    }

}
