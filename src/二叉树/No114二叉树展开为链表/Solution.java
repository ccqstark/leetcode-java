package 二叉树.No114二叉树展开为链表;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 法1：递归
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 先处理左边
        flatten(root.left);
        // 防止下面的操作导致右子树节点发生变化，这里先用个变量记录下来
        TreeNode originRight = root.right;
        if (root.left != null) {
            // join是左子树最右的一个节点，因为此时左子树已经链化，所以我们要找到链的末端，来拼接到右子树上
            TreeNode join = root.left;
            while (join.right != null) {
                join = join.right;
            }
            // 左子树拼到当前root的右边，然后root的左子树置空
            join.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // 之后再处理右边的
        flatten(originRight);
    }

    // 法2：前序遍历(迭代法)
    public void flatten2(TreeNode root) {
        if (root == null) return;
        // 前置节点
        TreeNode prev = null;
        // 需要一个栈
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            // 取出栈顶作为当前处理节点curr，也就是下一个接在链上的节点
            TreeNode curr = deque.pop();
            // prev左边置空，右边指向下一个也就是curr
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            // 注意入栈顺序是先右再左，取出顺序才能是先左后右
            if (curr.right != null) {
                deque.push(curr.right);
            }
            if (curr.left != null) {
                deque.push(curr.left);
            }
            // prev后移一位
            prev = curr;
        }
    }
}
