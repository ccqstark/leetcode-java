package 二叉树.No116填充每个节点的下一个右侧节点指针;

import 二叉树.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class Connect {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            // 记录上一个节点
            Node pre = queue.peek();
            while (len > 0) {
                Node node = queue.pollFirst();
                // 非本节点（行首节点）就指向下一个
                if (pre != node){
                    pre.next = node;
                }
                pre = node;
                if (node.left!=null){
                    queue.offerLast(node.left);
                }
                if (node.right!=null){
                    queue.offerLast(node.right);
                }
                len--;
            }
        }
        return root;
    }
}
