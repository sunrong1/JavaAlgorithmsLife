package queue;

/**
 * 问题类型：
 * 循环队列问题，结构设计
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/3/14 11:13
 */
public class NO_622_design_circular_queue_medium {
}

class MyCircularQueue {
    private int[] data;
    private int front;//头节点
    private int tail;//尾部节点
    private int count;//循环队列的数量

    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
        count = k + 1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % count;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % count;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + count) % count];
    }

    public boolean isEmpty() {
        if (front == tail) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((tail + 1) % count == front) {
            return true;
        }
        return false;
    }
}

