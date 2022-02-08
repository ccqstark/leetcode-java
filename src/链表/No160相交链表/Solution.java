package 链表.No160相交链表;


import 链表.ListNode;

/**
 * 本题同"面试题0207链表相交"
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a!=b){
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
