package sort;

import util.ArrayUtil;

/**
 * @program: JavaAlgorithmsLife
 * @description: 冒泡排序
 * 稳定的算法，原地排序
 * @author: dave
 * @create: 2025/9/23 12:50
 **/
public class BulbSort {
    public static void main(String[] args) {
        int [] a  = new int[]{2,1,3,4};

        ArrayUtil.print(bulb1Sort(a));
    }

    private static int[] bulb1Sort(int[] a) {
        //冒泡排序，最大的一个个排到后面
        //从做到右一个个选择最大的，排列到后面
        if (a == null || a.length <2) {
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length -i -1; j++) {
                if (a[j] > a[j+ 1]) {
                    int temp = a[j+ 1];
                    a[j+ 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
