package heap;

import java.util.*;

/**
 * 问题类型：
 * 堆的问题，概念，定义，性质
 * 优先队列：尾部进队列，头部出元素；每次都出最大/最小值；
 * <p>
 * Description
 * 堆是特殊空间的右顺序的完全二叉树，root是最大值的是大顶堆，其他未小顶堆
 * 堆排序(从小到大)：先建立大顶堆，然后进行循环操作，弹出堆头，放到堆尾部，调整堆；再循环操作；
 * 优先队列：通常是使用堆实现的；堆的一个重要应用。
 *
 * @author dave
 * @since 2021/4/9 21:03
 */
public class Heap {
    //自定义优先队列,大顶堆
    public static List<Integer> myPriorityQueue;

    public static void main(String[] args) {

        //Java内置的优先队列，默认以自然顺序排序,从小到大排列；
        Queue<Integer> priorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            priorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for (int i = 0; i < 7; i++) {
            System.out.println("Processing Integer:" + priorityQueue.poll());
        }
        myPriorityQueue = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            push(rand.nextInt(100));
        }
        for (int i = 0; i < 7; i++) {
            System.out.println("myPriorityQueue Integer:" + pop());
        }
        myPriorityQueue = new ArrayList<>();

    }

    /**
     * 入堆操作
     * <p>
     * Description
     * 在堆的尾部加入元素，开始上浮调整
     *
     * @Param [x]
     * @retrun void
     * @since 2021/4/9 22:05
     */
    public static void push(int x) {
        myPriorityQueue.add(x);
        //开始上浮操作
        int index = myPriorityQueue.size() - 1;
        int fatherIndex = (index - 1) / 2;
        while (index > 0 && myPriorityQueue.get(index) > myPriorityQueue.get(fatherIndex)) {
            swap(index, fatherIndex);
            index = fatherIndex;
            fatherIndex = (index - 1) / 2;
        }
        System.out.print("myPriorityQueue push");
        for (int i = 0; i < myPriorityQueue.size(); i++) {
            System.out.print(" " + myPriorityQueue.get(i));
        }
        System.out.println(" ");

    }

    /**
     * 出堆，向下调整
     * <p>
     * Description
     * 出堆的头部，将堆的最后一个插入头部，再向下调整
     *
     * @Param []
     * @retrun int
     * @since 2021/4/10 7:03
     */
    public static int pop() {
        if (myPriorityQueue.size() == 0) {
            return -1;
        }
        int ret = myPriorityQueue.get(0);
        myPriorityQueue.set(0, myPriorityQueue.get(myPriorityQueue.size() - 1));
        myPriorityQueue.remove(myPriorityQueue.size() - 1);
        int index = 0;
        int size = myPriorityQueue.size();
        while (index * 2 + 1 <= size - 1) {
            //最大值下标
            int maxIndex = index;
            if (myPriorityQueue.get(maxIndex) < myPriorityQueue.get(index * 2 + 1)) {
                maxIndex = index * 2 + 1;
            }
            if (index * 2 + 2 < size - 1 && myPriorityQueue.get(maxIndex) < myPriorityQueue.get(index * 2 + 2)) {
                maxIndex = index * 2 + 2;
            }
            if (maxIndex == index) {
                break;
            }
            swap(maxIndex, index);
        }
        return ret;

    }

    private static void swap(int maxIndex, int index) {
        int ret = myPriorityQueue.get(index);
        myPriorityQueue.set(index, myPriorityQueue.get(maxIndex));
        myPriorityQueue.set(maxIndex, ret);
    }

    public int peek() {
        return myPriorityQueue.get(0);
    }


}
