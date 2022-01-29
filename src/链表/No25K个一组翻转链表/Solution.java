package 链表.No25K个一组翻转链表;

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

public class Solution {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // k为1的话其实结果就和原来的一样，不用操作
        if (k == 1) {
            return head;
        }
        // 设置一个dummy头节点解决需要对头节点进行特判的问题
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null) {
            // tail从pre开始移动
            ListNode tail = pre;
            // 每次移动距离k
            for (int i = 0; i < k; i++) {
                // 不到k的后面就不处理了，直接返回
                if (tail.next == null) {
                    return dummyHead.next;
                }
                tail = tail.next;
            }
            // 记录当前子链表tail的下一个节点，准备翻转后可以和整体接上
            ListNode nex = tail.next;
            // 对子链表进行单独翻转
            ListNode[] nodeArr = reverseLinkList(head, tail);
            // 得到新的头节点和尾节点
            head = nodeArr[0];
            tail = nodeArr[1];
            pre.next = head;
            tail.next = nex;
            // 移动pre和head准备下一轮
            pre = tail;
            head = nex;
        }

        return dummyHead.next;
    }

    public ListNode[] reverseLinkList(ListNode head, ListNode tail) {
        // 反转链表，老思路就行
        ListNode pre = tail.next;
        ListNode h = head;
        while (pre != tail) {
            ListNode nex = h.next;
            h.next = pre;
            pre = h;
            h = nex;
        }
        // 返回一个数组包括tail和head（翻转之后头尾交换了）
        return new ListNode[]{tail, head};
    }

}