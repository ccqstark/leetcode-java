package 链表.No203移除链表元素;

import 链表.ListNode;

public class Solution {

    // 原链表操作
    public ListNode removeElements1(ListNode head, int val) {

        ListNode ptr = head;

        while (ptr != null && ptr.next != null) {

            if (ptr == head && ptr.val == val) {
                // 删除头节点情况
                head = head.next;
                ptr = head;
            } else if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        // 处理只有一个节点的情况
        if (head != null && head.next == null && head.val == val){
            return null;
        }

        return head;
    }


    // 虚拟头节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode virtualHead = new ListNode(0, head);
        ListNode ptr = virtualHead;

        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return virtualHead.next;
    }

}
