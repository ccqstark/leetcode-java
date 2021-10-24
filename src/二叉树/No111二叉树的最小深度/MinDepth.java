package 二叉树.No111二叉树的最小深度;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinDepth {

    // 深度优先法
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树都为空，代表已经到叶子节点了
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 去获取左右子树中，深度最浅的
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        // +1代表本层
        return minDepth + 1;
    }

    // 广度优先法（层序遍历）
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.pollFirst();
                // 左右节点都为空直接返回当前深度
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                len--;
            }
            // 遍历完一层深度+1
            minDepth++;
        }
        return minDepth;
    }

}
