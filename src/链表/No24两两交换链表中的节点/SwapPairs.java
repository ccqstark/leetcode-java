package 链表.No24两两交换链表中的节点;

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

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 空链表 / 只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 要返回的新头节点
        ListNode newHead = head.next;
        // vhear left right tail
        // 增加一个虚拟头节点和其它标记节点
        ListNode vhead = new ListNode(0, head);
        ListNode left = head;
        ListNode right = left.next;
        ListNode tail = right.next;
        while (true) {
            // 改变方向
            vhead.next = right;
            right.next = left;
            left.next = tail;

            // 交换完最后一组 / 数量为奇数，最后一个不成一组
            if (tail == null || tail.next == null) {
                break;
            }

            // 移动到下一组
            vhead = left;
            left = tail;
            right = left.next;
            tail = right.next;
        }
        return newHead;
    }
}
