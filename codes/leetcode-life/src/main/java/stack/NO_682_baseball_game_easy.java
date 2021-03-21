package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题类型：
 * 栈的实际应用问题
 * <p>
 * Description
 * 根据前几次的积分，计算这次积分；
 *
 * @author dave
 * @since 2021/3/21 7:06
 */
public class NO_682_baseball_game_easy {

    public static void main(String[] args) {
        String[] input = new String[]{"5", "2", "C", "D", "+"};
        int ret = calPoints(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 简单的条件计算题，只要认真些就可以
     * Description
     *
     * @Param [ops]
     * @retrun int
     * @since 2021/3/21 7:19
     */
    private static int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.peek();
                    stack.push(a);
                    stack.push(a + b);
                }
                break;
                case "C":
                    stack.pop();
                    break;
                case "D": {
                    int a = stack.peek();
                    stack.push(a * 2);
                }
                break;

                default:
                    stack.push(Integer.parseInt(ops[i]));
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
