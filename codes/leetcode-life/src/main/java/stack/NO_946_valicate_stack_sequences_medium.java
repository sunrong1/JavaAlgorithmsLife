package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题类型：
 * Stack的操作问题
 * <p>
 * Description
 * 验证栈序列，pushed 和 popped 两个序列，判读它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果
 *
 * @author dave
 * @since 2021/3/21 11:41
 */
public class NO_946_valicate_stack_sequences_medium {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        boolean ret = validateStackSequences(pushed, popped);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 模拟栈法，使得栈和pop中的值比较(像贪心法)
     * Description
     * 所有的元素一定是按顺序 push 进去的，重要的是怎么 pop 出来。关键是Pop的数组
     * pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     *
     * @Param [pushed, popped]
     * @retrun boolean
     * @since 2021/3/21 14:24
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pLength = 0;

        for (int i = 0; i < popped.length; i++) {
            //出栈的元素，要么是栈顶元素，要么是写一个要入栈的元素
            while (stack.isEmpty() || (pLength < pushed.length && stack.peekFirst() != popped[i])) {
                //出栈的序列是要入栈的元素
                stack.push(pushed[pLength++]);
            }
            if (stack.peekFirst() != popped[i]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
