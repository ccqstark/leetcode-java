package 链表.No206反转链表;

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

public class ReverseList {

    public ListNode reverseList(ListNode head) {
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
}
