package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题类型：
 * 双指针的相关问题
 * <p>
 * Description
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * @author dave
 * @since 2021/2/14 21:42
 */
public class NO_15_3_sum_medium {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> ret = threeSum(nums);
        for (List<Integer> g : ret) {
            for (int i = 0; i < g.size(); i++) {
                System.out.println(g.get(i));
            }
        }
    }

    /**
     * 双指针法，左右指针
     * 1. 排序 2：取出一个数nums[i]，寻找2sum = 0- nums[i]
     * 难点：去重，当前的数字和上次的一样，去掉;否则就两边的指针都向前移动
     * 优化1：根据数字大小判断，如果nums[i] >= 0 肯定没有
     * 优化2：合为0，左右都移动
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);

        //优化1 最小最大值规律 1 2 3 4 -->0
        if (nums[0] > 0) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> integerList = new ArrayList<Integer>();
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    integerList = new ArrayList<Integer>();
                    integerList.add(nums[i]);
                    integerList.add(nums[left]);
                    integerList.add(nums[right]);
                    lists.add(integerList);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return lists;
    }
}
