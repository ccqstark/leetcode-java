package 栈与队列.No1047删除字符串中的所有相邻重复项;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {

    // 使用栈
    public String removeDuplicates1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) { // 如果栈顶与当前字符重复则pop出来
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        // 将剩下的字符串拿出来
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }

        return str;
    }

    // 双指针法
    public String removeDuplicates2(String s) {
        char[] ch = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            ch[slow] = ch[fast]; // 用快指针的值直接覆盖慢指针
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--; // 遇到重复2个的，回退一格
            } else {
                slow++; // 没有重复的就前进
            }
            fast++;
        }
        return new String(ch, 0, slow); // 左闭右开
    }

}
