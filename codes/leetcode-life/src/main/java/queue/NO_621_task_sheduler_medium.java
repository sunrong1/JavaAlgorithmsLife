package queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 问题类型：
 * 队列问题
 * <p>
 * Description
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 计算完成所有任务所需要的 最短时间
 *
 * @author dave
 * @since 2021/3/22 7:07
 */
public class NO_621_task_sheduler_medium {

    public static void main(String[] args) {
        char[] input = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int ret = leastInterval(input, 2);
        System.out.println(ret);
    }


    /**
     * 方法1：
     * 构造填充法
     * Description
     * 先找到任务最多的A(可能是多个)，A任务之间必须有n的冷却时间，我们肯定可以使用其他任务去填充，其他任务
     *
     * @Param [tasks, n]
     * @retrun int
     * @since 2021/3/26 7:10
     */
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : tasks) {
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
            max = Math.max(max, num);
        }
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> e : set) {
            if (e.getValue() == max) {
                maxCount++;
            }
        }
        //如何证明这个是最佳的答案
        //(maxExec−1)(n+1)+maxCount，需要假设
        int sum = Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
        return sum;
    }
}
