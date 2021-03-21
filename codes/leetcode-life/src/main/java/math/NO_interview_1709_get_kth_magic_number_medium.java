package math;

/**
 * 问题类型：
 * 数学规律问题，数学归纳法,动态规划，堆
 * <p>
 * Description
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数
 * ，前几个数按顺序应该是 1，3，5，7，9，15，21
 *
 * @author dave
 * @since 2021/3/14 21:35
 */
public class NO_interview_1709_get_kth_magic_number_medium {

    public static void main(String[] args) {
        int input = 5;
        int ret = getKthMagicNumber(input);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 动态规划，TODO:需要进行证明
     * Description
     *
     * @Param [k]
     * @retrun int
     * @since 2021/3/18 22:16
     */
    public static int getKthMagicNumber(int k) {
        int[] nums = new int[k];
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        nums[0] = 1;
        for (int i = 1; i < k; i++) {
            //取出乘积最小的放入队列
            nums[i] = Math.min(nums[p3] * 3, Math.min(nums[p5] * 5, nums[p7] * 7));
            //因子指针后移
            if (nums[p3] * 3 == nums[i]) {
                p3++;
            }
            if (nums[p5] * 5 == nums[i]) {
                p5++;
            }
            if (nums[p7] * 7 == nums[i]) {
                p7++;
            }
        }
        return nums[k - 1];
    }
}
