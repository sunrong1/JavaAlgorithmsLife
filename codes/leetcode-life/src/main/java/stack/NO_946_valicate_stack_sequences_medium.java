package stack;

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
        int[] popped = new int[]{1, 2, 3, 4, 5};
        boolean ret = validateStackSequences(pushed, popped);
        System.out.println(ret);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        return true;
    }
}
