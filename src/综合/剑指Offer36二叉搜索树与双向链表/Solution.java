package 综合.剑指Offer36二叉搜索树与双向链表;

import 二叉树.Node;

/**
 * 一道树与链表结合的题（也挺高频的，要好好掌握）
 */
public class Solution {

    Node pre = null; // 当前节点的前驱节点
    Node head = null; // 头节点

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 还是循环链表，所以还要处理头尾节点，此时pre就是尾节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;
        // 中序遍历
        dfs(cur.left);

        if (pre != null) {
            // 构建双向指针
            pre.right = cur;
            cur.left = pre;
        } else {
            // 由于是中序，所以一直递归到最小的那个节点停下，所以此时就是头节点而pre还没被赋值过
            head = cur;
        }

        // pre移到当前cur位置
        pre = cur;

        // 递归处理右子树（中序遍历嘛）
        dfs(cur.right);
    }

}
