package 链表.No138复制带随机指针的链表;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    /**
     * 朴素做法：先把所有节点都赋值一遍并用哈希表对应存起来
     * 之后第二次遍历再通过哈希表的对应关系去补全next和random关系
     */
    public Node copyRandomList2(Node head) {
        Node p = head;
        HashMap<Node, Node> hashmap = new HashMap<>();
        while (p != null) {
            hashmap.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        Node newHead = hashmap.get(head);
        while (p != null) {
            hashmap.get(p).next = hashmap.get(p.next);
            hashmap.get(p).random = hashmap.get(p.random);
            p = p.next;
        }

        return newHead;
    }

    /**
     * 递归+哈希表
     */
    HashMap<Node, Node> hashmap = new HashMap<>();

    public Node copyRandomList(Node head) {
        // 判断我们要复制的节点是否已经存在于哈希表中了
        if (!hashmap.containsKey(head)) {
            if (head == null) {
                return null;
            }
            Node newNode = new Node(head.val);
            hashmap.put(head, newNode);
            // next和random的获取利用递归
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        // 如果哈希表中存在就直接返回
        return hashmap.get(head);
    }
}
