package array;

/**
 * 问题类型：
 * 双指针类问题；数组原址操作
 * <p>
 * Description
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 空间复杂度必须O(1)
 *
 * @author dave
 * @since 2021/2/16 10:15
 */
public class NO_26_remove_duplicates_from_array_simple {
    public static void main(String[] args) {
        int[] array = {1, 1, 2};
        int ret = removeDuplicates(array);
        System.out.println(ret);

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }
        //初始化新字符串长度为1
        int newLenght = 1;
        for (int i = 1; i < nums.length; ) {
            if (nums[i] == nums[newLenght - 1]) {
                i++;
            } else {
                newLenght++;
                nums[newLenght - 1] = nums[i];
                i++;
            }
        }


        for (int i = 0; i < newLenght; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        return newLenght;
    }
}


