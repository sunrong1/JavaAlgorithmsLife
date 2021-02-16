package array;

/**
 * 问题类型：
 * 双指针类问题，数组平移操作
 * <p>
 * Description
 * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * @author dave
 * @since 2021/2/16 11:32
 */
public class NO_27_remove_element_easy {
    public static void main(String[] args) {
        int[] array = {3, 1, 1, 3};
        int val = 3;
        int ret = removeElement_removeFast(array, val);
        System.out.println(ret);

    }

    /**
     * 方法1：
     * 当行前移，删除重复数据
     * 双指针法，一个快指针-进行数组遍历，一个慢指针，保存删除重复数据后的数据
     * 优点：平行前移，可以保存原数组的顺序
     * 缺点：删除数据较少时，效率较低
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        //初始化新字符串长度为0，同时也表示新数组的初始指针的指向位置
        int newLenght = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == val) {
                i++;
            } else {
                nums[newLenght] = nums[i];
                newLenght++;
                i++;
            }
        }
        for (int i = 0; i < newLenght; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        return newLenght;
    }

    /**
     * 方法2：
     * 尾部数据跳跃前移
     * 双指针法，一个快指针-进行数组遍历，一个慢指针，尾部数据指针
     * 优点：可以保存原数组的顺序
     * 缺点：删除数据较少时，效率较低
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement_removeFast(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        //初始化新字符串长度为0，同时也表示新数组的初始指针的指向位置
        int newLenght = nums.length;
        int fastIndex = 0;
        while (fastIndex < newLenght) {

            if (nums[fastIndex] == val) {
                nums[fastIndex] = nums[newLenght - 1];
                newLenght--;
            } else {
                fastIndex++;
            }

        }

        for (int i = 0; i < newLenght; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        return newLenght;
    }
}
