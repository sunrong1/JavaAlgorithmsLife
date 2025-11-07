package sort;

import util.ArrayUtil;

import static util.ArrayUtil.swap;

/**
 * @program: JavaAlgorithmsLife
 * @description: 第k最大的数
 * @author: dave
 * @create: 2025/11/3 13:16
 **/
public class NO_215_kth_largest_medium {
    public static void main(String[] args) {
//        int[] input = new int[]{3, 2, 1, 5, 6, 4};
//        int[] input = new int[]{3, 1, 2, 4};
        int[] input = new int[]{4,5,1,3,2};
        System.out.println(findKthLargest(input, 5));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || k> nums.length) {
            return -1;
        }
        heapSort(nums);
        ArrayUtil.print(nums);
        int heapSize = nums.length;
        //从大顶堆，弹出根，就是最大的，弹出k-1次
        //k =1时，不循环
        //k =2时，循环1次
        for (int i = nums.length-1; i > nums.length -k; i--) {
            //最大和最后一个叶子节点交换
            swap(nums,0,i);
            //当前这个节点，构建heap
            heapSize--;
            heapify(nums,heapSize,0);
        }
        return nums[0];
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //数组长度
        int n  = arr.length;

        //从最后一个非叶子节点的根节点开始，遍历所有的根节点
        //因为节点 i的左子是 2i+1。当 2i+1 ≥ n时，说明它没有孩子，是叶子。解这个不等式得到 i < (n−1)/2，也就是非叶子都在 0 ~ floor((n−1)/2)。
        //在 0 起始整数除法里，floor((n−1)/2) 就是 n//2 − 1。
        for (int i = n/2 -1; i >= 0; i--) {
            heapify(arr,n,i);
        }
    }

    /**
     * 对第i个节点进行堆化
     * 递归对i的子节点进行堆化
     * @param arr
     * @param n
     * @param i
     */
    private static void heapify(int[] arr, int n, int i) {
        //最大点
        int max = i;
        //左节点
        int l = 2* i+ 1;
        //右边节点
        int r = 2* i+ 2;
        //左节点大
        if (l < n && arr[l] > arr[max]){
            max = l;
        }
        //如果右边的更大，更新最大值
        if (r < n && arr[r]> arr[max]){
            max = r;
        }
        if (max != i){
            swap(arr,i,max);//最大值到根节点
            heapify(arr,n,max);//递归调用，保证交换后的节点的子节点，也是大顶堆
        }
    }
}
