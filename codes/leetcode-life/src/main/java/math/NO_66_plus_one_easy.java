package math;

import util.ArrayUtil;

/**
 * 问题类型：
 * 数学计算问题，进位问题
 * <p>
 * Description
 * 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一
 *
 * @author dave
 * @since 2021/3/4 6:50
 */
public class NO_66_plus_one_easy {

    /**
 * 主函数，演示数组加一操作
 * @param args 命令行参数（未使用）
 */
public static void main(String[] args) {
        int[] input = {9, 9, 8};
        int[] ret = plusOne_after(input);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1
     * 数学规律  加1前进位的判断
     * 注意，数组的存储数据和index是倒序的
     *
     * @param digits 非空数组表示的非负整数
     * @return 加一后的数组
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * 方法2
     * 数学规律 +1后数字的判断
     * 注意，数组的存储数据和index是倒序的
     *
     * @param digits 非空数组表示的非负整数
     * @return 加一后的数组
     */
    public static int[] plusOne_after(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] % 10 == 0) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}
