package 二叉树.No103二叉树的锯齿形层序遍历;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 本题也就是著名的：二叉树之字形遍历
 * 思路：利用一个双端队列，通过控制不同遍历方向改变poll和offer的位置即可实现
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 首先把根节点放进去
        deque.offerFirst(root);
        // 循环直到为空
        while (!deque.isEmpty()) {
            // 假设双端队列左边是头，右边是尾
            // 要先记下当前size，然后从左到右进行遍历
            int size = deque.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 从头取数
                TreeNode node = deque.pollFirst();
                sublist.add(node.val);
                // 左、右子树从尾入队，保证下一次遍历是逆序
                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            }
            ans.add(sublist);

            List<Integer> resublist = new ArrayList<>();
            // 更新size，此时是从右到左方向
            size = deque.size();
            for (int i = 0; i < size; i++) {
                // 从尾拿树
                TreeNode node = deque.pollLast();
                resublist.add(node.val);
                // 右、左子树从头入队，保证下一次遍历是正序
                if (node.right != null) deque.offerFirst(node.right);
                if (node.left != null) deque.offerFirst(node.left);
            }
            // 这里需要额外判断一下，避免最后一层没节点我们加入一个空list
            if (resublist.size() > 0) {
                ans.add(resublist);
            }
        }
        return ans;
    }
}
