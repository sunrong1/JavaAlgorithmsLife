package stack;

import java.util.Stack;

/**
 * 问题类型：
 * 栈的操作问题，栈和队的转换问题
 * <p>
 * Description
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * @author dave
 * @since 2021/3/21 6:48
 */
public class NO_Interview0304_implement_queue_using_stack_easy {
}

/**
 * 方法1：
 * 栈和队列的最大区别是顺序不同
 * Description
 * 使用双栈，一个只负责输出，一个只负责输入
 *
 * @Param
 * @retrun
 * @since 2021/3/21 6:49
 */
class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        reverseStack();
        if (popStack.isEmpty()) {
            return -1;
        }
        return popStack.pop();
    }

    private void reverseStack() {
        if (!popStack.isEmpty()) {
            return;
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        reverseStack();
        if (popStack.isEmpty()) {
            return -1;
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */