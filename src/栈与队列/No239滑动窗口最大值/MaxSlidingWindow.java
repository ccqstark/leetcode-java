package 栈与队列.No239滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    // 解法2：利用双端队列手动实现单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列中存放的是元素在原数组里的下标
        Deque<Integer> deque = new ArrayDeque<>();
        // 原数组长度
        int n = nums.length;
        // 存放结果集
        int[] res = new int[n - k + 1];
        // 结果集指针
        int idx = 0;
        // 这里的i代表的是当前滑动窗口的右端点
        for (int i = 0; i < n; i++) {
            // 队列不为空 且 队头元素不在[i-k+1, i]范围内(即已经不在窗口内)
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // 出队头
            }
            // 队列不为空 且 队尾元素比当前元素小
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // 出队尾
            }

            // 入队
            deque.offer(i);

            // 当可以可以扫过第一个窗口后，开始把每个窗口的队头元素放入结果集中
            if (i >= k - 1) {
                res[idx++] = nums[deque.peek()];
            }
        }

        return res;
    }
}
