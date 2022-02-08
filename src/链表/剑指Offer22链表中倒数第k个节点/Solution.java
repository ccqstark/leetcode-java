package 链表.剑指Offer22链表中倒数第k个节点;

import 链表.ListNode;

public class Solution {
    int th = 0;
    ListNode ans;

    public ListNode getKthFromEnd(ListNode head, int k) {
        traverse(head, k);
        return ans;
    }

    // 链表后序遍历到第k个即可
    public void traverse(ListNode head, int k) {
        if (head == null) return;
        traverse(head.next, k);
        if (++th == k) ans = head;
    }

}
