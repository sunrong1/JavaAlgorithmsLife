package sort;

import util.ArrayUtil;


/**
 * 问题类型：
 * 排序问题，归并排序
 * <p>
 * Description
 * 煎饼翻转 完成对数组的排序
 *
 * @author dave
 * @since 2026/4/17 12:56
 */
public class NO_912_merge_sorting_medium {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 4, 1};
        mergeSort(input,0,input.length-1);
        ArrayUtil.print(input);
    }

    /**
     * 方法1 归并排序
     * 不关注具体的递归过程，关注子问题是怎么解决的，怎么能切分到子问题。
     * 
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 基准情形：当子数组长度为1时，直接返回
        if (left >= right) {
            return;
        }

        // 分治：将数组一分为二,一直往下分，直到子数组长度为1，进行左右合并，合并的连个数组都是有序数组
        int mid = left + (right - left) / 2;
        // merge the left and right part
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }


    private static void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组用于合并
        int[] temp = new int[right - left + 1];
        int i = left;    // 左半部分起始索引
        int j = mid + 1; // 右半部分起始索引
        int k = 0;       // 临时数组索引
        
        // 合并两个有序子数组
        while (i <= mid && j <= right) {
            if (arr[i]<arr[j]) {
                temp[k++]=arr[i];
                i++;
            }
            else {
                temp[k++]=arr[j];
                j++;
            }
        }
        //处理剩余元素
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        while (j<=right) {
            temp[k++] = arr[j++];
        }
        //将临时数组复制回原数组
        for (int l = 0; l < temp.length; l++) {
            arr[left+l] = temp[l];
        }

    }
}
