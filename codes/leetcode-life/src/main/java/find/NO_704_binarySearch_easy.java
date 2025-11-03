package find;

/**
 * @program: JavaAlgorithmsLife
 * @description: 二分查找
 * @author: dave
 * @create: 2025/10/29 13:17
 **/
public class NO_704_binarySearch_easy {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        System.out.println(search(array,2));
    }

    /**
     * while的条件判断可以优化
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int l =0;
        int r = nums.length -1;
        int mid = (l+ r) >> 1;
        while (true){
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else if (nums[mid] < target){
                l = mid +1;
            }
            else {
                return mid;
            }
            mid = (l+r)>>1;
            if (mid > r || mid < l){
                break;
            }
        }
        return -1;
    }
}
