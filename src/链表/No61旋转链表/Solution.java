package 链表.No61旋转链表;

import 链表.ListNode;

/**
 * 这道题其实没啥巧妙的地方，就是找到分割点，然后把拆成的两段重新组合一下而已
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 空链表/单节点/k为0不用操作的情况
        if (head == null || head.next == null || k == 0) return head;
        // 先遍历得到链表的长度，同时找到原尾节点tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        // k对n取余，因为如果反转次数等于链表长度相当于没操作
        k %= n;
        // 取余后为0说明k为n的整倍数，同样不用操作了
        if (k == 0) return head;

        // 找到切分点，就是n-k位置（倒数第k个位置）
        int pos = 1;
        ListNode cur = head;
        while (pos != n - k) {
            cur = cur.next;
            pos++;
        }
        // 拆后把第二部分移到前面就行了
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
}
