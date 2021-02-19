package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
public class NO_20_valid_parentheses_easy {
    public static void main(String[] args) {
        String input = "()[]{}";
        boolean ret = isValid(input);
        System.out.println(ret);
    }

    /**
     * 方法1
     * Stack 数据结构的操作
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //优化1：数学规律，非偶数个长度，肯定不匹配
        if (s == null) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> characterCharacterMap = new HashMap<Character, Character>();
        characterCharacterMap.put(')', '(');
        characterCharacterMap.put('}', '{');
        characterCharacterMap.put(']', '[');
        Stack<Character> characterStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (characterCharacterMap.get(s.charAt(i)) == null) {
                characterStack.add(s.charAt(i));
            } else {
                //右括号场景
                if (!characterStack.isEmpty() && characterCharacterMap.get(s.charAt(i)).equals(characterStack.pop())) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
