package 栈与队列.No225用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    // 思路一：使用两个队列，一个是主要实现的队列，另一个用来备份；插入时先插入到主队列，pop的时候先把主队列中除了最后一个之外的所有
    // 元素都放到备份队列中，再把那最后一个（也就是模拟的栈中的第一个）pop出，最后再把备份队列的元素放回主队列

    // 思路二：只需要一条队列，在思路一的基础上，pop的时候把除了最后一个之外的元素都一个个拿出再直接插到本队列的尾部，之后就可以把最后一个
    // pop出，而且其他元素的相对顺序也没有改变

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int step = queue.size() - 1;
        for (int i = step; i > 0; i--) {
            Integer element = queue.poll();
            queue.add(element);
        }

        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = 0;
        for (int i = queue.size(); i > 0; i--) {
            Integer element = queue.poll();
            queue.add(element);
            if (i == 1) {
                top = element;
            }
        }

        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */