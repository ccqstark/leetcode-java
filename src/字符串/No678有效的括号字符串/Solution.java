package 字符串.No678有效的括号字符串;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean checkValidString(String s) {
        // 分别用于存储左括号和*号的栈，存储的是元素对应下标
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // 遇到左括号和*号就直接压入栈中
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                // 遇到右括号优先使用左括号去匹配，左括号栈为空再去找*号栈，都没有则匹配失败
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        // 处理剩下的左括号和*号
        while (true) {
            if (!leftStack.isEmpty() && !starStack.isEmpty()) {
                // 如果两栈都不为空，且左括号栈顶下标小于*号栈顶坐标，说明可以把*号当作右括号和左括号进行匹配
                if (leftStack.pop() > starStack.pop()) {
                    return false;
                }
            } else if (!leftStack.isEmpty() && starStack.isEmpty()) {
                // 如果*号栈用完了左括号栈还有，那么就匹配失败
                return false;
            } else {
                // 剩余的情况就是左括号完了，*号栈还没完或者也完了就匹配成功
                // 因为*号还可以当作空字符串，空字符串一样是有效字符串
                return true;
            }
        }
    }
}
