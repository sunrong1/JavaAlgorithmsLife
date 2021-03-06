package util;

import java.util.List;

/**
 * 问题类型：
 * 数组共用函数提取问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/16 20:30
 */
public class ArrayUtil {
    public static void printIntListList(List<List<Integer>> lists) {
        if (lists == null) {
            System.out.println("----------null---------");
            return;
        }
        for (List<Integer> integerList : lists) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void print(List<Integer> lists) {
        if (lists == null) {
            System.out.println("----------null---------");
            return;
        }
        for (Integer list : lists) {
            System.out.print(list + " ");
        }
        System.out.println();
    }

    public static void print(int[] array) {
        if (array == null) {
            System.out.println("----------null---------");
            return;
        }
        for (Integer list : array) {
            System.out.print(list + " ");
        }
        System.out.println();
    }
}

