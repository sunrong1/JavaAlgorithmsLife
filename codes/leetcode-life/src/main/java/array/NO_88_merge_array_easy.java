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
 * @since 2025/9/15 13:06
 */
public class NO_88_merge_array_easy {
    public static void main(String[] args) {
        //int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        //int[] nums = {1, 0, -1, 0, -2, 2};
        //int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums1 = {3, 3, 5,0,0};
        int[] nums2= {1, 1};
        merge2(nums1,3, nums2,2);
        ArrayUtil.print(nums1);
    }
    /**
     * 双指针法，左右指针，在nums1的空间内进行合并，空间复杂度低
     *
     * @param nums
     * @param target
     * @return
     */
    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public  static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if (m ==0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
            
        }
        //双指针，i在nums1的末尾，j在nums2的末尾
        int i = m - 1;
        int j = n - 1;
        //从后往前一个个插入
        int k= m + n - 1;
        while (k>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
            //确保num2全部插入进去
            if (j<0 || i<0) {
                break;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
            
        }
    }
}