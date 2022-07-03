package 周赛.No300;

import 链表.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Two {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int up = 0, down = m - 1, left = 0, right = n - 1;
        ListNode p = head;
        int[][] matrix = new int[m][n];
        while (up <= down || left <= right) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    if (p == null) {
                        matrix[up][i] = -1;
                    } else {
                        matrix[up][i] = p.val;
                        p = p.next;
                    }
                }
                up++;
            }

            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    if (p == null) {
                        matrix[i][right] = -1;
                    } else {
                        matrix[i][right] = p.val;
                        p = p.next;
                    }
                }
                right--;
            }

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    if (p == null) {
                        matrix[down][i] = -1;
                    } else {
                        matrix[down][i] = p.val;
                        p = p.next;
                    }
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    if (p == null) {
                        matrix[i][left] = -1;
                    } else {
                        matrix[i][left] = p.val;
                        p = p.next;
                    }
                }
                left++;
            }
        }

        return matrix;
    }
}
