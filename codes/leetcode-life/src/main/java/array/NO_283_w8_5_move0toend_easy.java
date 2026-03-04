package array;

import java.util.HashMap;

import util.ArrayUtil;

/**
 * 问题类型：
 * 移动数组中的0到末尾，保持非0元素的相对位置不变
 * <p>
 * Description
 * 数组中，找到两个整数等于目标值的index
 *
 * @author dave
 * @since 2026/3/3 12:42
 */
public class NO_283_w8_5_move0toend_easy {
    public static void main(String[] args) {
        int[] array = { 1, 0, 0, 7, 11, 15, 0 };
        Move1(array);
        ArrayUtil.print(array);
    }

    /**
     * M1：双指针的方法，左右移动。has problem
     * 0移动到了最后，但是非0元素的相对位置变了
     * 
     * @param nums
     * @return
     */
    public static int[] Move0(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length < 1) {
            return nums;
        }
        while (left < right) {
            // 右指针向左移动，直到找到一个非0的数; 且右边的比左边的大
            while (nums[right] == 0 && right > left) {
                right--;
            }
            if (nums[left] == 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
            left++;
        }
        return nums;
    }

    /**
     * M2：保持位置不变的双指针移动，两边夹逼的方式不行，需要用快慢指针
     * 
     * @param nums
     * @return
     */
    public static void Move1(int[] nums) {
        int slow = 0;
        if (nums.length < 1) {
            return;
        }
        int fast = 0;
        while (fast < nums.length) {
            // slow找到第一个为0的数
            while (slow < nums.length && nums[slow] != 0) {
                slow++;
            }
            fast = slow + 1;
            // fast找到第一个非0的数
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            if (fast >= nums.length) {
                break;
            }
            // slow和fast交换
            nums[slow] = nums[fast];
            nums[fast] = 0;
            slow++;
        }

    }

}
