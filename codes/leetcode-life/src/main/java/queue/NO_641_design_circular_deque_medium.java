package queue;

/**
 * 问题类型：
 * 循环队列问题，结构设计
 * <p>
 * Description
 * 设计循环双端队列，622题目的简单升级版本
 *
 * @author dave
 * @since 2021/3/14 7:29
 */
public class NO_641_design_circular_deque_medium {
}

/**
 * 方法1：
 * 数组实现方式
 */
class MyCircularDeque {
    private int[] data;
    private int front;//头节点
    private int tail;//尾部节点
    private int count;//循环队列的数量

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * 注意：循环队列要预留一位
     */
    public MyCircularDeque(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
        count = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //注意-1 可能为负数，所以要+ count
        front = (front - 1 + count) % count;
        data[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % count;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % count;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + count) % count;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        //CARE:计算
        return data[(tail - 1 + count) % count];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (front == tail) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if ((tail + 1) % count == front) {
            return true;
        }
        return false;
    }
}
