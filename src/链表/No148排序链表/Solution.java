package 链表.No148排序链表;

import 链表.ListNode;

/**
 * 要实现O(nlogn)时间复杂度的话我们一般想到快排和归并
 * 但是在链表上进行快排不太现实，所以我们用归并排序
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sortListHelper(head, null);
    }

    public ListNode sortListHelper(ListNode start, ListNode end) {
        if (start == end) return start;
        // 快慢指针找出链表中点，用于拆成2段链表
        ListNode fast = start, slow = start;
        // 注意这里fast中止条件是用end而不是null，否则当链表只有两个节点的时候拆不断
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 递归，继续拆分，因为用了递归所以空间复杂度其实是O(logn)
        ListNode l2 = sortListHelper(slow.next, end);
        slow.next = null; // 记得断掉前后链表联系，不然可能会出现环
        ListNode l1 = sortListHelper(start, slow);

        return merge(l1, l2);
    }

    // 这个就是合并两个有序链表而已
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
