package 二叉树.No117填充每个节点的下一个右侧节点指针II;

import 二叉树.Node;

public class Connect {
    /**
     * 基本思路是遍历此行时把下一行串起来，之后就可以遍历下一行，并可以把下下行串起来
     * 按此方法就可以遍历并串起所有行
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 相当于一个虚拟头节点，置于下一行的头部
        Node dummy = new Node(0);
        Node cur = root;
        while (cur != null) {
            // 新起一行记得重置下，不然会判断不到最后一行cur为null而死循环
            dummy.next = null;
            Node pre = dummy;
            while (cur != null) {
                // 判断左右节点不为null就可以串起来
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                // 继续此行下一个节点的遍历
                cur = cur.next;
            }
            // 跳到下一行，因为dummy是下一行的虚拟头
            cur = dummy.next;
        }

        return root;
    }
}
