package 链表.No143重排链表;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 法1：存储法，用一个列表存储所有的节点，然后双指针从头尾取点重排
     */
    public void reorderList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int i = 0, j = list.size() - 1;
        // 用于构建新的链表
        ListNode cur = new ListNode();
        while (i <= j) {
            // 如果是奇数个的话i和j会重合
            if (i == j) {
                cur.next = list.get(i);
                break;
            }
            // 先接i再接j
            cur.next = list.get(i);
            cur.next.next = list.get(j);
            // 把cur移动到当前链表最后
            cur = cur.next.next;
            // 收缩指针
            i++;
            j--;
        }
        // 避免循环链表，把最后一个节点的next置为null
        list.get(i).next = null;
    }


    /**
     * 法2：递归法
     */
    public void reorderList2(ListNode head) {
        // 节点数为0、1、2时不用处理
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        // 求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        // 节点数为奇数
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        // 节点数为偶数
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        // 得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理，len-2就是去头去尾了
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next; // 中间链表的头结点
        head.next = tail; // 连接本层的head和对应tail
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead; // 连接本层的tail和subhead

        // 最终把上一层对应的tail返回，给递归的上一层使用
        return outTail;
    }


    /**
     * 法3（强烈推荐）: 寻找链表中点 + 链表逆序 + 合并链表
     * 这道题用这种解法一下子考察了多个链表的多个知识点，所以面试官希望你用这种方法解答
     */
    public void reorderList3(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null; // 记得尾部为置为null
        l2 = reverseList(l2); // l2进行反转
        mergeList(l1, l2); // 最后合并
    }

    // No876 链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next==null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    // No206 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 合并两个链表
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
