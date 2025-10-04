package sort;

import util.ArrayUtil;

/**
 * @program: JavaAlgorithmsLife
 * @description: 快速排序
 * 不稳定的排序算法
 * @author: dave
 * @create: 2025/9/26 12:49
 **/
public class QuickSort {
    public static void main(String[] args) {
        int [] a  = new int[]{2,1,3,4};

        ArrayUtil.print(quick1Sort(a));
    }

    private static int[] quick1Sort(int[] a) {
        //递归的方式，不断的拆分，拆分后，小的数组里面，以最后的数字作为pivot，进行左右比较，获得中间的参考位置pos
        //终止条件，最后只剩余一个数，l>=r 截止
        quick1Sort(a,0,a.length-1);
        return a;
    }

    private static void quick1Sort(int[] a,int l,int r) {
        if (l>= r) {
            return;
        }
        //获得分区位置，先从大的数据分区，再一个个分区小的数组
        int pos  = partion(a,l,a.length-1);
        quick1Sort(a,l,pos -1);
        quick1Sort(a,pos + 1,r);
    }

    private static int partion(int[] a, int l, int r) {
        //选择最后一个数字，作为分区点
        int p = a[r];
        //先从一边开始遍历,先确定一个边界，小于p的边界为r
        int i= l-1;
        int j = r -1;
        //左边是小于p的，右边是大于p的
        while (l<=r-1) {
            if (a[l] > p) {
                //交换到j的位置
                i++;
                int tmp = a[l];
                a[l] = a[i];
                a[j] = tmp;
            }
            l++;

        }
        //j的后面都是大于p的
        //l的前面都是小于p的
        a[r] = a[i+1];
        a[i+1]= p;
        return i+1;
    }

}
