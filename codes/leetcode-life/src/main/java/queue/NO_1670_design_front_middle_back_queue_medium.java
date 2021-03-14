package queue;

import java.util.LinkedList;

/**
 * 问题类型：
 * 队列的设计问题，复杂结构设计
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/3/14 18:50
 */
public class NO_1670_design_front_middle_back_queue_medium {
/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}

/**
 * 方法1：
 * 使用Java的内置链表辅助实现
 */
class FrontMiddleBackQueue {

    //使用Java内置的链表，也可以自己建立链表结构，
    // 此链表特性：双向链表，有size()记录
    LinkedList<Integer> data;

    public FrontMiddleBackQueue() {
        data = new LinkedList<>();
    }

    public void pushFront(int val) {
        data.addFirst(val);
    }

    public void pushMiddle(int val) {
        //插入的位置，如果是奇数，是取前面的位置
        int middle = data.size() / 2;
        data.add(middle, val);
    }

    public void pushBack(int val) {
        data.addLast(val);
    }

    public int popFront() {
        if (data.isEmpty()) {
            return -1;
        }
//        return data.getFirst();
//        return data.removeFirst();
        //推荐直接使用这个
        return data.pollFirst();
    }

    //注意：偶数个数时，会存在两个中间位置数据的场景，我们取前一个
    public int popMiddle() {
        if (data.isEmpty()) {
            return -1;
        }
        //取数的位置，如果个数是偶数，是取前面的位置
        int middle = data.size() / 2;
        if (data.size() % 2 == 0) {
            //注意Get方法不删除原链表
            return data.remove(middle - 1);
        } else {
            return data.remove(middle);
        }
    }

    public int popBack() {
        if (data.isEmpty()) {
            return -1;
        }
        //推荐直接使用这个,不会产生异常
        return data.pollLast();
    }
}

