package stack;

import java.util.*;

/**
 * 问题类型：
 * 栈的问题：数据结构的特点和使用
 * <p>
 * Description
 * 判断字符串中括号是否有效
 *
 * @author dave
 * @since 2021/2/18 22:06
 */
public class NO_1614_max_parentheses_easy {
    public static void main(String[] args) {
        String input = "()(())";
        int ret = maxDepth(input);
        System.out.println(ret);
    }

    public static int maxDepth(String s) {
        int max = 0;
        int ret =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                max++;
            }
            else if (s.charAt(i)==')') {
                max--;
            }
            ret = Math.max(ret, max);
        }
        return ret;
        
    }


}
