package sort;

import java.util.Arrays;

import static util.ArrayUtil.swap;

/**
 * @program: JavaAlgorithmsLife
 * @description: 堆排序
 * @author: dave
 * @create: 2025/11/5 12:53
 **/
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4, 10, 3, 5, 1};
//        int[] arr = {3, 1, 2, 4,5};
        int[] arr = {4,5,1,3,2};
        System.out.println("排序前: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    /**
     * 方法1 从下往上建立堆，时间复杂度低，效率高
     * 完全二叉树，从最后一个非叶子节点的根开始创建
     * @param arr
     */
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //堆的大小
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
