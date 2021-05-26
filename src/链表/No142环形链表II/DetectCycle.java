package 链表.No142环形链表II;

import java.util.HashSet;

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

public class DetectCycle {
    // 法1： 快慢指针
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    // 法2：哈希表
    public ListNode detectCycle2(ListNode head) {
        ListNode p = head;
        HashSet hashSet = new HashSet<ListNode>();
        while (p!=null){
            if (hashSet.contains(p)){
                return p;
            }else {
                hashSet.add(p);
            }
            p = p.next;
        }

        return null;
    }

}
