package stack;

import util.ArrayUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题类型：
 * stack问题，函数的调用问题
 * <p>
 * Description
 * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时
 *
 * @author dave
 * @since 2021/3/27 7:11
 */
public class NO_636_exclusive_time_of_functions_medium {
    public static void main(String[] args) {
        int n = 1;
        List<String> logs = new LinkedList<>();

        // ["0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"]
        logs.add("0:start:0");
        logs.add("0:start:1");
        logs.add("0:start:2");
        logs.add("0:end:3");
        logs.add("0:end:4");
        logs.add("0:end:5");

        int[] ret = exclusiveTime(n, logs);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1：
     * 使用Stack模拟函数的调用
     * Description
     * <p>
     * 每个函数都有一个唯一的 Id，从 0 到 n-1
     * ["0:start:0",
     * "1:start:2",
     * "1:end:5",
     * "2:start:6",
     * "2:end:7",
     * "0:end:8"]
     *
     * @Param [n, logs]
     * @retrun int[]
     * @since 2021/3/30 6:44
     */
    public static int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new LinkedList<>();
        int[] time = new int[n];

        //记录上一个的时间戳
        int preTimestamp = 0;
        for (int i = 0; i < logs.size(); i++) {
            //解析日志
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            String state = log[1];
            int timestamp = Integer.parseInt(log[2]);
            //判断日志中状态
            //遇到start 要分两种情况，stack为空和非空
            if (state.equals("start")) {
                if (stack.isEmpty()) {
                    stack.push(id);
                    preTimestamp = timestamp;
                } else {
                    time[stack.peekFirst()] += timestamp - preTimestamp;
                    stack.push(id);
                    preTimestamp = timestamp;
                }
            } else {
                //遇到end，函数弹出，当前函数调用结束，函数都是近邻成对出现
                time[id] += timestamp - preTimestamp + 1;
                stack.pop();
                //注意，下个函数的起始时间就是 当前时间 + 1了
                preTimestamp = timestamp + 1;
            }

        }
        return time;

    }
}
