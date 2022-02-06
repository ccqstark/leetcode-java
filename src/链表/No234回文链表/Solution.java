package 链表.No234回文链表;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 下面的快慢指针+反转链表的时间复杂度是O(N),空间复杂度是O(1)
 * 其他空间复杂度差一点的做法一般是整个链表反转再比较、用栈的、用链表后序遍历等方法都有需要使用额外空间的缺点
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        slow = fast = head;
        // 快慢指针找出中间位置和最后位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如国快指针不是为null，说明链表数为奇数，slow要移到中间节点的下一个
        if (fast != null) {
            slow = slow.next;
        }
        // 反转后半段链表
        ListNode tail = reverseList(slow);
        // 然后就可以从左右向中间并拢来判断回文了
        while (tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    /**
     * 反转链表，和之前的一样，返回新的头节点也就是最右的那个节点
     */
    public ListNode reverseList(ListNode head) {
        // 当题目给的链表长度为1时传过来的head为null，直接返回即可
        if (head == null) {
            return head;
        }
        ListNode pre = null, p = head;
        while (p != null) {
            ListNode nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return pre;
    }

}