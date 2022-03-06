package 栈与队列.剑指Offer09用两个栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

    // 一个出栈，一个入栈
    Deque<Integer> in;
    Deque<Integer> out;

    public CQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    // 插入的时候直接push到入栈即可
    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        // 如果出栈不为空，则直接pop出栈的数据
        if (!out.isEmpty()) {
            return out.pop();
        } else if (!in.isEmpty()) {
            // 如果出栈为空，入栈不为空，则把入栈的数据都搬到出栈，再pop
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }
        // 都为空就表示整个队列都为空了
        return -1;
    }
}
