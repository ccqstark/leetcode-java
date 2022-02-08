package 链表.No2两数相加;

import 链表.ListNode;

/**
 * 这题用模拟法，和"No415字符串相加"如出一辙，不细说了
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int c = a + b + add;
            ListNode newNode = new ListNode(c % 10);
            add = c / 10;
            p.next = newNode;
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return ans.next;
    }
}
