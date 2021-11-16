package 二叉树.No1038把二叉搜索树转换为累加树;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ccqstark
 * @description 此题和538相同，这里用迭代法
 * @date 2021/11/16 19:55
 */
public class BstToGst {

    private int pre = 0; // 此值实际上就是大于本节点的所有节点值之和

    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>(); // 用一个栈实现右中左顺序
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 把当前不为null的节点放入栈中，并进入的右子节点
                stack.push(cur);
                cur = cur.right;
            } else {
                // 如果当前的节点为null，就去栈中pop一个作为中间节点处理
                TreeNode mid = stack.pop();
                mid.val += pre;
                pre = mid.val;
                // 去往左子节点
                cur = mid.left;
            }
        }

        return root;
    }
}
