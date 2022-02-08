package 链表.No141环形链表;

import 链表.ListNode;

import java.util.HashSet;

public class Solution {
    /**
     * 哈希表法，set存节点地址，出现重合证明有环
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode p = head;
        set.add(p);
        while (true) {
            if (p == null || p.next == null) {
                return false;
            }
            p = p.next;
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
    }

    /**
     * 快慢指针法，如果有环快慢指针之后会重合
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { // 判断出null证明无环
            slow = slow.next; // 一次走一格
            fast = fast.next.next; // 一次走两格
            if (slow == fast) { // 重合证明有环
                return true;
            }
        }
        return false;
    }

}
