package 二叉树.迭代遍历.普通迭代法;

import java.util.*;

import 二叉树.TreeNode;

/**
 * @author ccqstark
 * @description 三种遍历的普通迭代式写法（非同一）
 * @date 2022/10/28 23:40
 */
public class Solution {

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 因为最终我们要的顺序是「中左右」，但是栈会导致顺序反过来，所以是先右再左
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        // 这里还要判断一次 cur!=null 的原因是：当你遍历到整棵树靠右的一侧时，
        // 可能会有栈为空，但是 cur 不为空的状态，这个时候还是需要继续遍历下去的
        while (cur != null || !stack.isEmpty()) {
            // 用 cur 不断找到最左侧的节点，期间路过的节点都加入到栈中
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // 发现cur为空，可能是遇到最左下角节点了，也可能刚遍历完左节点现在遍历中节点了
                // 出栈并加入到结果集中
                cur = stack.pop();
                res.add(cur.val);
                // 去右子树遍历
                cur = cur.right;
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
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 和前序遍历反过来，最后再reverse
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        //「中右左」->「左右中」
        Collections.reverse(res);
        return res;
    }
}
