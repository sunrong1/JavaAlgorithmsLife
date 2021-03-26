package string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/3/24 6:52
 */
public class NO_227_basic_calculator_ii_medium {

    public static void main(String[] args) {
        String input = " 2*2";
        int ret = calculate(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 使用栈,先保存第一个字符，然后每次计算 * 2 ；+2；。/2 这种结构
     * Description
     * 先计算 * / 法，最后计算+ - 法
     *
     * @Param [s]
     * @retrun int
     * @since 2021/3/24 7:00
     */
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        //先取第一个数
        int j = 0;
        while (j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-' && s.charAt(j) != '*' && s.charAt(j) != '/') {
            j++;
        }
        int num = Integer.parseInt(s.substring(i, j).trim());
        stack.push(num);

        while (j < s.length()) {
            char op = s.charAt(j);
            //i和j跳到下个数字
            j++;
            i = j;
            //取下一个数
            while (j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-' && s.charAt(j) != '*' && s.charAt(j) != '/') {
                j++;
            }
            int num2 = Integer.parseInt(s.substring(i, j).trim());
            switch (op) {
                case '+':
                    stack.push(num2);
                    break;
                case '-':
                    stack.push(-num2);
                    break;
                case '*': {
                    int temp = stack.pop();
                    stack.push(temp * num2);
                    break;
                }
                case '/': {
                    int temp = stack.pop();
                    stack.push(temp / num2);
                    break;
                }
                default:
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
