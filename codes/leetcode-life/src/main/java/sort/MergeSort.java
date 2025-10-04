package sort;

import util.ArrayUtil;

import java.lang.reflect.Array;

/**
 * @program: JavaAlgorithmsLife
 * @description: 归并排序
 * 稳定的排序算法
 * 比较交换的排序
 * @author: dave
 * @create: 2025/9/24 13:02
 **/
public class MergeSort {
    public static void main(String[] args) {
        int [] a  = new int[]{2,1,3,4};

        ArrayUtil.print(merge1Sort(a));
    }

    private static int[] merge1Sort(int[] a) {
        //递归的方法：递归公式，递归的截止条件
        //递归公式：m(arr) = m(arr（left）) , m(arr(right)),再合并
        //截止条件：left >=right
        merge1Sort_start(a,0,a.length-1);
        return a;
    }

    private static void merge1Sort_start(int[] a, int l, int r) {
        if (l>= r) {
            return;
        }
        int mid = (r+l)>> 1;//注意mid是真实的数组的中间编号
        merge1Sort_start(a,l,mid);
        merge1Sort_start(a,mid + 1,r);
        merge(a,l,mid,r);
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int ll = mid -l +1;
        int rr = r -mid;//实际是mid+1起始位置
        int [] ret = new int[rr + ll];
        //进行合并，先共同部分合并，这部分需要比较合并
        int i =l;//左边位置
        int j = mid + 1;//右边待合并位置
        int k =0;//合并的位置
        while (i <= mid && j <= r){
            if (a[i] > a[j]) {
                ret[k] = a[j];
                k++;
                j++;
            }
            else {
                ret[k]= a[i];
                k++;
                i++;
            }
        }
        //剩余的左边的合入
        while (i<=mid){
            ret[k] = a[i];
            i++;
            k++;
        }
        //剩余的右边合入
        while (j <= r){
            ret[k]= a[j];
            k++;
            j++;
        }
        //数据搬迁回去
        k=0;
        i =l;
        while (k < ll+ rr){
            a[i++] = ret[k++];
        }
    }
}
