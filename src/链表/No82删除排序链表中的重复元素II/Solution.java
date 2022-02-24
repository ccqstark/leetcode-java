package 链表.No82删除排序链表中的重复元素II;

import 链表.ListNode;

public class Solution {
    // 迭代法
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // 其实就是遍历，遇到下一个节点和下下个节点val相等的情况下，就去找最近的可以跳过它们的节点
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                cur.next = findFirstNotVal(cur.next.val, cur.next);
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 找到第一个值不为tval的节点，用于跳过那些值相同的节点
    public ListNode findFirstNotVal(int tval, ListNode cur) {
        while (cur != null) {
            if (cur.val != tval) return cur;
            cur = cur.next;
        }
        return cur;
    }

    // 递归法
    public ListNode deleteDuplicates(ListNode head) {
        // baseCase
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 当下一个节点与当前头节点val相同，那包括头节点在哪的序列都要删除
        if (head.val == next.val) {
            // 找到第一个与当前head节点值不同的节点
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            // 因为head要删除，所以递归结果赋值给head
            head = deleteDuplicates(next);
        } else {
            // head可以保留，递归结果接到当前head后面
            head.next = deleteDuplicates(next);
        }

        return head;
    }

}
