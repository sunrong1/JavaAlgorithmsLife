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
        for (List<Integer> integerList : lists) {
            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i) + " ");
            }
            System.out.println();
        }
    }
}
