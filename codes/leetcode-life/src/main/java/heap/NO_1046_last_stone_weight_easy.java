package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题类型：
 * 集合最值问题，堆问题
 * <p>
 * Description
 * 最后一块石头的重量
 *
 * @author dave
 * @since 2021/4/10 22:48
 */
public class NO_1046_last_stone_weight_easy {

    public static void main(String[] args) {
        int[] input = {2, 7, 4, 1, 8, 1};
        int ret = lastStoneWeight(input);
        System.out.println(ret);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a == b) {
                continue;
            }
            priorityQueue.add(a - b);
        }
        if (priorityQueue.size() > 0) {
            return priorityQueue.peek();
        }
        return 0;
    }
}
