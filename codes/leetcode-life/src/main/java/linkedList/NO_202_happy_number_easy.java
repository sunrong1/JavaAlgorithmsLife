package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题类型：
 * 数学规律问题，假设验证问题，最终转换为循环链表的问题
 * <p>
 * Description
 * 判断一个数 n 是不是快乐数(1)
 *
 * @author dave
 * @since 2021/3/5 22:05
 */
public class NO_202_happy_number_easy {

    public static void main(String[] args) {


        boolean ret = isHappy(2);
        System.out.println(ret);
    }

    public static boolean isHappy(int n) {
        Set<Integer> nodeSet = new HashSet<>();
        int next = getSum(n);
        while (nodeSet.add(next)) {
            next = getSum(next);
        }
        if (next == 1) {
            return true;
        }
        return false;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            sum += temp * temp;
        }
        return sum;
    }
}
