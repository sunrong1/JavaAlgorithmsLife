package array;

/**
 * 问题类型：
 * 二分法问题
 * <p>
 * Description
 * 在排序数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * @author dave
 * @since 2021/2/20 6:59
 */
public class NO_35_search_insert_position_easy {

    public static void main(String[] args) {
        int[] array = {1, 1, 2};
        int val = 3;
        int ret = searchInsert(array, val);
        System.out.println(ret);

    }

    /**
     * 二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //while是left>right时跳出循环，所以插入到left的位置
        return left;
    }
}
