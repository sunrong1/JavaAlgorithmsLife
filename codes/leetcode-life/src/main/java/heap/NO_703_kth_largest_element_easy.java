package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/4/14 6:54
 */
public class NO_703_kth_largest_element_easy {

    public static void main(String[] args) {
        int[] input = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, input);
        int ret = kthLargest.add(3);
        // ret = kthLargest.add(5);
        System.out.println(ret);
    }

    public static class KthLargest {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //返回True时交换，所以输出小顶堆
                return o1 - o2;
            }
        });

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                //注意这个初始化的处理过程，保持堆的结构
                add(nums[i]);

            }
        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }

}
