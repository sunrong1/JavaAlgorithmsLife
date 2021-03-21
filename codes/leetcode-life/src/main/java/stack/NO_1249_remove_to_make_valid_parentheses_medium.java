package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题类型：
 * 括号表达式匹配问题，Stack类问题
 * <p>
 * Description
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效
 *
 * @author dave
 * @since 2021/3/21 19:35
 */
public class NO_1249_remove_to_make_valid_parentheses_medium {

    public static void main(String[] args) {
        String input = "((())";
        String ret = minRemoveToMakeValid_version2(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * <p>
     * Description
     * 建立一个Stack，存储左括号，去匹配后面的字符，Stack没有匹配的就删除此字符
     * 删除字符注意技巧，直接删除比较困难，先删除需要删除的字符Index，后面统一处理
     *
     * @Param [s]
     * @retrun java.lang.String
     * @since 2021/3/21 19:38
     */
    public static String minRemoveToMakeValid(String s) {
        StringBuffer ret = new StringBuffer();
        Deque<Character> stack = new LinkedList<>();

        //场景分析：
        //((())
        //))((
        //())
        //())
        Deque<Integer> list = new LinkedList<>();
        List<Integer> removeIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //如果遇到(括号，压栈，同时保存当前字符的index
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                list.push(i);
            } else if (s.charAt(i) == ')') {
                //如果栈为空，直接删除当前字符
                //否则就弹出当前的栈
                if (stack.isEmpty()) {
                    removeIndex.add(i);
                } else {
                    stack.pop();
                    list.pop();
                }
            }
        }
        while (!list.isEmpty()) {
            removeIndex.add(list.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndex.contains(i)) {
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }

    /**
     * 方法2：方法1的简化版本
     * 假设都需要删除，如果匹配就不删除
     * <p>
     * Description
     * 建立一个Stack，存储左括号，去匹配后面的字符，Stack没有匹配的就删除此字符
     * 删除字符注意技巧，直接删除比较困难，先删除需要删除的字符Index，后面统一处理
     *
     * @Param [s]
     * @retrun java.lang.String
     * @since 2021/3/21 19:38
     */
    public static String minRemoveToMakeValid_version2(String s) {
        //StringBuilder 比StringBuffer 在单线程效率更高
        StringBuilder ret = new StringBuilder();
        //场景分析：
        //((())
        //))((
        //())
        //())
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> removeIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //如果遇到(括号，压栈，同时保存当前字符的index
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                //如果栈为空，直接删除当前字符
                //否则就弹出当前的栈
                if (stack.isEmpty()) {
                    removeIndex.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            removeIndex.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndex.contains(i)) {
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }
}
