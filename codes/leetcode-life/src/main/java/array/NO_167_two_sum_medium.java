package array;

import util.ArrayUtil;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 * 找出 无重复元素的数组candidates 中所有可以使数字和为 target 的组合
 *
 * @author dave
 * @since 2026/3/4 12:26
 */
public class NO_167_two_sum_medium {

    /**
     * 两数之和2：升级版本，非递减序列的两数之和
     * 
     * 
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // int[] nums = {-2, -1, -1, 1, 1, 2, 2};

        int[] nums = { 2, 3, 5, 7, 11, 15 };
        int target = 8;
        int[] ret = twoSum(nums, target);
        ArrayUtil.print(ret);
    }

    /**
     * M1: 使用滑动窗口方法
     * 
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[0];
        }
        // 左右指针进行夹逼
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            // 如果相等，则返回
            if (numbers[left] + numbers[right] == target) {
                // 返回结果，注意索引从1开始
                return new int[] { left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
