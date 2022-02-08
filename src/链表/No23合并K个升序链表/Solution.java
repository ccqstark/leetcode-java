package 链表.No23合并K个升序链表;

import 链表.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    // 法1：二分法来合并, 代码也挺直观的
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 这个纯属就是"合并两个有序链表"题目的解了
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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

    // 法2：这个是顺序合并，没啥好说的，就是一个个来merge咯
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    // 法3：借助优先队列，这个的话就是我们定义优先队列按val从小到大排序
    // 然后一开始把所有头节点都放进去，然后每当取出一次就是拿到了当前所有链表当前所处位置的最小值
    // 每取处一次，就要把把取出节点的下一个节点放进去优先队列中
    // 说白了不过是"合并两个有序链表"的那种双指针思路我们扩展到"k个指针"，每次拿到k个指针中的最小那个值
    // 只不过k个指针太多了很难写，所以才借助了优先队列这种高级数据结构，面试中应该最好不要用，优先用二分法吧
}
