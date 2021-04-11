package heap;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题类型：
 * 排序问题，堆问题
 * <p>
 * Description
 * 找出其中最小的 k 个数
 *
 * @author dave
 * @since 2021/4/10 22:08
 */
public class NO_offer40_min_k_numbers_easy {
    public static void main(String[] args) {
        int[] input = {0, 0, 0, 2, 0, 5};
        int[] ret = getLeastNumbers_sort(input, 0);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1：
     * 大顶堆方案
     * Description
     * 先构建K个元素的大顶堆，然后插入的数据比堆顶还小，就插入到堆中；
     *
     * @Param [arr, k]
     * @retrun int[]
     * @since 2021/4/10 22:10
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k < 1) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //先构建K个元素的大顶堆
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        //逐步比较，向堆中插入小的元素
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        int[] arrRet = new int[k];
        for (int i = 0; i < k; i++) {
            arrRet[i] = priorityQueue.poll();
        }

        return arrRet;
    }

    /**
     * 方法2：
     * 直接排序
     * Description
     *
     * @Param [arr, k]
     * @retrun int[]
     * @since 2021/4/10 22:44
     */
    public static int[] getLeastNumbers_sort(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
