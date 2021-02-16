package array;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题类型：
 * 双指针查找问题+排序
 * <p>
 * Description
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等
 *
 * @author dave
 * @since 2021/2/15 23:31
 */
public class NO_18_4_sum_medium {
    public static void main(String[] args) {
        //int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        //int[] nums = {1, 0, -1, 0, -2, 2};
        //int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        List<List<Integer>> ret = fourSum(nums, target);
        ArrayUtil.printIntListList(ret);
    }

    /**
     * 比3sum的问题，多了一层的循环，相当于要固定两个数，再进行双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);

        //优化1 最小最大值规律 1 2 3 4 -->0
        if (nums[0] > 0 && nums[0] > target) {
            return lists;
        }
        //-4 -3 -2 -1 --> 1
        if (nums[nums.length - 1] < 0 && target > 0) {
            return lists;
        }
        //第一步：固定i
        for (int i = 0; i < nums.length; i++) {

            //固定值1，去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                //固定值2，去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        List<Integer> integerList = new ArrayList<Integer>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[left]);
                        integerList.add(nums[right]);
                        lists.add(integerList);

                        //双指针的去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //只变化一个值，肯定不等于target，所以可以同时移动两个指针
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }

                }
            }
        }
        return lists;
    }

}
