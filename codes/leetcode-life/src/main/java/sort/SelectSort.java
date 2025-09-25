package sort;

import util.ArrayUtil;

/**
 * @program: JavaAlgorithmsLife
 * @description: 选择排序
 * 非稳定排序
 * @author: dave
 * @create: 2025/9/25 13:06
 **/
public class SelectSort {
    public static void main(String[] args) {
        int [] a  = new int[]{2,1,3,4,0};

        ArrayUtil.print(select1Sort(a));
    }

    private static int[] select1Sort(int[] a) {
        //和插入排序类似，都是分为两部分，一部分排序好的，一部分是未排序的
        //插入排序是1个个移动插入，选择排序，是先选择出最小的，放到前面有序的序列
        //有序序列的后一个空间
        int i =0;
        while (i < a.length -1){
            //最小位的索引号
            int k = i;
            int j = i;
            while (j < a.length){
                if(a[k] > a[j]){
                    k =j;
                }
                j++;
            }
            //最小的数，插入到前面排序的最后一位
            int tmp  = a[i];
            a[i] = a[k];
            a[k] = tmp;
            i++;
        }
        return a;
    }
}
