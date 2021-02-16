package array;

import java.util.Arrays;

/**
 * 问题类型：
 * 双指针的问题+排序
 * <p>
 * Description
 * 找出 nums 中的一组的三个整数，使得它们的和与 target 最接近
 *
 * @author dave
 * @since 2021/2/15 10:11
 */
public class NO_16_3_sum_closest_medium {
    public static void main(String[] args) {
        int[] nums = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        // int[] nums = {-1, 2, 1, -4};
        int target = 0;
        int ret = threeSumClosest(nums, target);
        System.out.println(ret);

    }

    /**
     * 先排序，然后使用双指针查找
     * <p>
     * 优化1：不需要保存上一次的结果；
     * 避免的优化2：差值的符号变化，不一定就是最优解；同时避免提前优化，解题和编码都是一步步开始；
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int min_sum = 0;

        if (nums == null) {
            return min_sum;
        }
        if (nums.length <= 3) {
            for (int num : nums) {
                min_sum += num;
            }
            return min_sum;
        }
        Arrays.sort(nums);
        min_sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int allSum = nums[i] + nums[left] + nums[right];
                if (allSum == target) {
                    return allSum;
                } else if (allSum > target) {
                    right--;
                } else {
                    left++;
                }
                //注意：差值扩大，不一定要停止本次循环
                if (Math.abs(allSum - target) < Math.abs(min_sum - target)) {
                    min_sum = allSum;
                }
            }
        }
        return min_sum;
    }

    public static int threeSumClosest2(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;

    }
}
