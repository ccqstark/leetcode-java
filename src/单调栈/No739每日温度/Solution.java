package 单调栈.No739每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 用于存放结果的数组
        int[] result = new int[temperatures.length];
        // 栈里存的不是元素的值，而是它们的下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            /**
             * 栈从上到下是递增的
             * 遍历到当前的数大于栈顶的数就要pop出，计算距离，直到不大于为止
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 计算第一个比它大的数的距离
                result[stack.peek()] = i - stack.peek();
                // 栈顶这个较小数出栈
                stack.pop();
            }
            // 每个数都要入栈，等待下一次操作
            stack.push(i);
        }

        return result;
    }
}
