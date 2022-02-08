package 链表.面试题0207链表相交;

import 链表.ListNode;

public class Solution {
    /**
     * 法1：设链表A的长度为a，B的长度为b，两表从头节点到交叉节点的距离分别为c和d
     * 由于交叉的节点是引用的节点，所以两链表从交叉节点开始后面全部的节点都是一样的，长度肯定也是一样的
     * 所以有a-c = b-d => a+d = b+c
     * 所以从A开始走的指针走完就走B，从B开始走的走完就走A（同步一起走），一起走了（a+d）或（b+c）步时就到了那个交叉点了
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    /**
     * 法2：由于交叉点后面的节点序列都是完全相同的，所以先算出两表的长度
     * 再算出长度差n，移动那个长度较大的链表的指针n位使得两表末尾对齐
     * 对齐后两指针同步向后移动就可以到达交叉点了
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 计算两表的长度
        int a = 0, b = 0;
        ListNode ap = headA;
        ListNode bp = headB;
        while (ap != null) {
            a++;
            ap = ap.next;
        }
        while (bp != null) {
            b++;
            bp = bp.next;
        }
        // 末尾对齐
        ap = headA;
        bp = headB;
        int step = a > b ? a - b : b - a;
        if (a > b) {
            while (step != 0) {
                ap = ap.next;
                step--;
            }
        } else {
            while (step != 0) {
                bp = bp.next;
                step--;
            }
        }
        // 最后同步移动寻找交叉点
        while (ap != bp) {
            ap = ap.next;
            bp = bp.next;
        }

        return ap;
    }

}

