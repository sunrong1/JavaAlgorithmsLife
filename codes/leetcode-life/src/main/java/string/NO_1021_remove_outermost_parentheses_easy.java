package string;

/**
 * 问题类型：
 * string的问题，stack的思想解决
 * <p>
 * Description
 * 删除最外层的括号
 *
 * @author dave
 * @since 2021/3/21 15:01
 */
public class NO_1021_remove_outermost_parentheses_easy {

    public static void main(String[] args) {
        String input = "(())";
        String ret = removeOuterParentheses(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 字符串找位置分割
     * Description
     *
     * @Param [S]
     * @retrun java.lang.String
     * @since 2021/3/21 16:50
     */
    public static String removeOuterParentheses(String S) {
        StringBuffer ret = new StringBuffer();
        //遇到左括号+ 1，否者-1，当到为0 的位置的时候，就是一组
        int count = 0;
        for (int i = 0, pre = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                //正常截取从pre 的位置，截取到当前i的位置[pre,i)
                String temp = S.substring(pre, i + 1);
                //去掉头和尾部的字符
                ret.append(temp, 1, temp.length() - 1);
                //PS：更简化的操作，但是不太容易理解
                //ret.append(S, pre + 1, i + 1 - 1);
                pre = i + 1;
            }

        }
        return ret.toString();
    }
}
