package sort;

import util.ArrayUtil;

/**
 * 插入排序
 * 左边有序，右边无序，一个个插入到左边的序列中
 * since 2025-9-22
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] a  = new int[]{2,1,3,4};

        ArrayUtil.print(intert1Sort(a));
    }


    private static int[] intert1Sort(int[] a) {

        //从左边第一个数开始，默认是第一个是有序的
        //右边的第一个数，默认是无序的，一个个插入到左边
        for (int i = 1; i < a.length; i++) {
            int temp  = a[i];//缓存下来，这个空间，给了左边的有序数组
            //左边的有序数组是从0开始，到i的位置,技巧：从后往前遍历，减少移动次数
            int j = i-1;
            for (; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j+1] = a[j];//不断向后移动
                }
                else {
                    break;
                }
            }
            a[j+1] = temp;
        }
        
        return a;
    }
}
