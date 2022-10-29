package 二叉树.迭代遍历.统一迭代法;

import 二叉树.TreeNode;

import java.util.*;

/**
 * @author ccqstark
 * @description 二叉树的统一迭代法（建议记这版）
 * @date 2022/10/29 10:59
 */
public class Solution {

    /**
     * 三种写法区别只在左中右的操作顺序不同，这点就很类似递归遍历了
     * 都是按原本节点的顺序反过来操作(push入栈)，因为用了栈，然后中节点后面要用null节点来标记
     * 标记的作用是表示该节点已经路过了，但是还没加到结果集中，下一次 pop 的时候遇到再加到结果集中
     * 因为每一个节点都是自己所在子树的中节点，统一标记对象，之后到叶子节点的时候可以正确遍历到
     * 而每种不同的遍历方式具体的不同之处其实体现在push入栈的顺序不同
     */

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 因为需要用null节点作为标记，所以不能用Deque了，Deque不支持null节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                // 中左右 -> 右左中
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            } else {
                stack.pop();
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                // 左中右 -> 右中左
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);
            } else {
                stack.pop();
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                // 左右中 -> 中右左
                stack.push(cur);
                stack.push(null);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            } else {
                stack.pop();
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

}
