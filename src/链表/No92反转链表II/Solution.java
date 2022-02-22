package 链表.No92反转链表II;

import 链表.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left和right相等直接返回
        if (left == right) {
            return head;
        }
        // 防止left在头节点，所以加一个虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        // left的前一个节点，right的后一个节点
        ListNode leftofleft = p, rightofright = p;
        for (int i = 0; i <= right; i++) {
            if (i == left - 1) {
                leftofleft = p;
            }
            p = p.next;
        }
        rightofright = p;

        // 原来的left所在位置的节点，之后会成为新链表的tail
        ListNode originLeft = leftofleft.next;

        // 下面这一段就是反转链表I的逻辑了
        ListNode pre = leftofleft.next;
        ListNode cur = pre.next;
        while (left < right) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            left++;
        }
        // 新链表头尾接回母链表
        leftofleft.next = pre;
        originLeft.next = rightofright;

        // 注意：由于原head可能也被反转到后面了，所以要用虚拟头节点的next返回
        return dummy.next;
    }
}
