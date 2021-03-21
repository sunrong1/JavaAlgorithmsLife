package string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题类型：
 * String问题，对stack 类问题的解决
 * <p>
 * Description
 * 删除字符串中的所有相邻重复项
 *
 * @author dave
 * @since 2021/3/20 7:02
 */
public class NO_1047_remove_all_adjacent_duplicates_string_easy {

    public static void main(String[] args) {

        String input = "aaba";
        String ret = removeDuplicates(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 使用Stack数据类型模拟操作；
     * Description
     *
     * @Param [S]
     * @retrun java.lang.String
     * @since 2021/3/20 7:12
     */
    private static String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && S.charAt(i) == stack.peekFirst()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuffer ret = new StringBuffer();
        while (!stack.isEmpty()) {
            ret.append(stack.pollLast());
        }
        return ret.toString();
    }

    /**
     * 方法2：
     * 使用StringBuffer数据类型模拟Stack操作；
     * Description
     *
     * @Param [S]
     * @retrun java.lang.String
     * @since 2021/3/20 7:19
     */
    private static String removeDuplicates_stringBuffer(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top >= 0 && S.charAt(i) == stack.charAt(top)) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(S.charAt(i));
                top++;
            }
        }

        return stack.toString();
    }
}
