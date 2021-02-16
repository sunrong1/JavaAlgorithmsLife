package array;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 * 找出 无重复元素的数组candidates 中所有可以使数字和为 target 的组合
 *
 * @author dave
 * @since 2021/2/16 20:26
 */
public class NO_39_combination_sum_medium {

    public static void main(String[] args) {
        //int[] nums = {-2, -1, -1, 1, 1, 2, 2};

        int[] nums = {2, 3, 5};
        int target = 8;
        List<List<Integer>> ret = combinationSum(nums, target);
        ArrayUtil.printIntListList(ret);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 4) {
            return lists;
        }
        return lists;
    }
}
