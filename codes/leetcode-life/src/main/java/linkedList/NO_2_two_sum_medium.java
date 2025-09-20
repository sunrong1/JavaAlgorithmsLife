package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题类型：
 * 数据结构设计相关问题
 * <p>
 * Description
 * 数组中，找到两个整数等于目标值的index
 *
 * @author dave
 * @since 2021/2/11 21:42
 */
public class NO_2_two_sum_medium {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] ret = addTowSum(array, 26);
        if (ret.length > 1) {
            System.out.println(ret[0] + " " + ret[1]);
        }

        int[] ret2 = addTowSum2(array, 26);
        if (ret2.length > 1) {
            System.out.println(ret2[0] + " " + ret2[1]);
        }

    }

}
