package 链表.No206反转链表;

import 链表.ListNode;

public class Solution {

    // 迭代法
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 记下cur的下一个节点，方便之后跳转
            ListNode tmp = cur.next;
            // 转换指针方向
            cur.next = pre;
            // pre向右移动一位
            pre = cur;
            // cur向右移动一位
            cur = tmp;
        }
        return pre;
    }

    // 递归法
    public ListNode reverseList(ListNode head) {
        // "head == null"是空链表情况，"head.next == null"表示到达了原尾节点，也就是新头节点位置
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next); // 新头节点，也就是原尾节点
        head.next.next = head; // 反转相邻指针指向
        head.next = null; // 原本的头节点/现在的尾节点的next一定要是null
        return newHead; // 最后返回的还是新头节点
    }
}
