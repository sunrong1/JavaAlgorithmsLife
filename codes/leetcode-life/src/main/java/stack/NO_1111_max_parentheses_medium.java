package stack;

import java.util.*;

import util.ArrayUtil;

/**
 * 问题类型：
 * 栈的问题：数据结构的特点和使用
 * <p>
 * Description
 * 有效括号的嵌套深度
 *
 * @author dave
 * @since 2021/2/18 22:06
 */
public class NO_1111_max_parentheses_medium {
    public static void main(String[] args) {
        String input = "()(())";
        int[] ret = maxDepthAfterSplit(input);
        ArrayUtil.print(ret);
    }

    /**
     * 寻找数学规律,可以先根据规律写出来
     * 
     * @date 2026/4/2 13:30
     * @param seq
     * @return
     */
    public static int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] result = new int[length];
        int d = 0;
        for (int i = 0; i < length; i++) {
            if (seq.charAt(i) == '(') {
                d++;
                // 对半分，奇书层分配个A，偶数层分配个B
                result[i] = d % 2;
            } else {
                // meet the ),the number is not changed,but the minus the depth
                result[i] = d % 2;
                d--;
            }
        
        }
        return result;
    }

}
