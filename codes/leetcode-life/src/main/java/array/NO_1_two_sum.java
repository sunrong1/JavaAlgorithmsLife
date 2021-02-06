package array;

import java.util.HashMap;
import java.util.Map;

//从数组中，找到两个整数等于目标值的index
public class NO_1_two_sum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int[] ret = addTowSum(array, 26);
        if (ret.length > 1) {
            System.out.println(ret[0] + " " + ret[1]);
        }

        int[] ret2 = addTowSum2(array, 26);
        if (ret2.length > 1) {
            System.out.println(ret2[0] + " " + ret2[1]);
        }

    }

    //方法1,傻瓜式双循环
    public static int[] addTowSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //目标是找nums[i] + nums[j] = target中的i，j值
    //1.用Map存储历史比对过的nums[i], 用target- nums[j] 去循环匹配，如果匹配到，就说明匹配成功，返回key的value即可
    public static int[] addTowSum2(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(target - nums[i])) {
                return new int[]{i, integerMap.get(target - nums[i])};
            } else {
                integerMap.put(nums[i], i);
            }
        }
        return new int[0];
    }

    //目标是找nums[i] + nums[j] = target中的i，j值
    //1.用Map存储需要的target - nums[i], 用nums[j] 去循环匹配，如果匹配到，就说明匹配成功，返回key的value即可
    public static int[] addTowSum3(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(nums[i])) {
                return new int[]{i, integerMap.get(nums[i])};
            } else {
                integerMap.put(target - nums[i], i);
            }
        }
        return new int[0];
    }
}
