package 链表.No19删除链表的倒数第N个节点;

import 链表.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 空链表 / 只有一个节点的情况
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        // 添加虚拟头节点
        ListNode vhead = new ListNode(0, head);
        // 其实位置都在头部
        ListNode fast = vhead;
        ListNode slow = vhead;
        // fast指针先走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        // 两指针一起移动
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 停止移动时，slow的下一个节点就是要被删除的节点
        slow.next = slow.next.next;

        return vhead.next;
    }
}
