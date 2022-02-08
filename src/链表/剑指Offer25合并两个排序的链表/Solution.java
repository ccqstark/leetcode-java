package 链表.剑指Offer25合并两个排序的链表;

import 链表.ListNode;

public class Solution {
    /**
     * 这题最简单直观的方法就是双指针厉然后再开一个新链表，哪个小就把哪个接到新链表后面
     * 直接把原链表中的节点摘下来接到新链表即可，不必复制新节点浪费空间
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头节点使代码更简洁
        ListNode dummy = new ListNode(0), cur = dummy;
        // 只有两方都还没完才继续
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { // 摘下l1的
                cur.next = l1;
                l1 = l1.next;
            } else {  // 摘下l2的
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 最后要把有剩的也拼过去
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
