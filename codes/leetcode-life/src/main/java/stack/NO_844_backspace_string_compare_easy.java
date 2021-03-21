package stack;

/**
 * 问题类型：
 * 栈的操作问题
 * <p>
 * Description
 * 比较含退格的字符串
 *
 * @author dave
 * @since 2021/3/21 7:21
 */
public class NO_844_backspace_string_compare_easy {

    public static void main(String[] args) {
        String input1 = "ab#c";
        String input2 = "ad#c";
        boolean ret = backspaceCompare(input1, input2);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 使用StringBuffer模拟栈
     * Description
     *
     * @Param [S, T]
     * @retrun boolean
     * @since 2021/3/21 7:23
     */
    public static boolean backspaceCompare(String S, String T) {

        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int top1 = -1;
        int top2 = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stringBuffer1.append(S.charAt(i));
                top1++;
            } else {
                if (top1 != -1) {
                    stringBuffer1.deleteCharAt(top1);
                    top1--;
                }
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stringBuffer2.append(T.charAt(i));
                top2++;
            } else {
                if (top2 != -1) {
                    stringBuffer2.deleteCharAt(top2);
                    top2--;
                }
            }
        }
        return stringBuffer1.toString().equals(stringBuffer2.toString());
    }
}
