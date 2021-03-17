package sort;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * 排序问题，指定特殊方式排序
 * <p>
 * Description
 * 煎饼翻转 完成对数组的排序
 *
 * @author dave
 * @since 2021/3/17 20:56
 */
public class NO_969_pancake_sorting_medium {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 4, 1};
        List<Integer> ret = pancakeSort(input);
        ArrayUtil.print(ret);
    }

    /**
     * 方法1
     *
     * @param arr
     * @return
     */
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<>(arr.length);
        //需要反转n-1次，每次找到最大值反转，先反转到头部，再反转到尾部
        for (int i = arr.length - 1; i > 0; i--) {
            //找到最大值
            int index = findIndexOfMax(arr, i);
            //如果index 是i的位置，不需要操作，位置正确；否则要进行两次煎饼反转
            if (index != i) {
                //先反转到头部，再反转到尾部
                //如果已经再头部，就不需要第一次反转了
                if (index == 0) {
                    ret.add(i + 1);
                    pancakeReverse(arr, i);
                    continue;
                }
                ret.add(index + 1);
                ret.add(i + 1);
                pancakeReverse(arr, index);
                pancakeReverse(arr, i);
            }

        }
        return ret;
    }

    private static void pancakeReverse(int[] arr, int index) {
        for (int i = 0; i <= index / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[index - i];
            arr[index - i] = temp;
        }
    }

    private static int findIndexOfMax(int[] arr, int i) {
        int index = 0;
        for (int j = 1; j <= i; j++) {
            if (arr[j] > arr[index]) {
                index = j;
            }
        }
        return index;
    }

}
