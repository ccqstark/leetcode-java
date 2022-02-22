package 链表.No876链表的中间结点;

import 链表.ListNode;

public class Solution {
    // 快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
