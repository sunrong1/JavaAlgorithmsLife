package stack;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 * 表现良好的最长时间段:「劳累的天数」是严格 大于「不劳累的天数」
 *
 * @author dave
 * @since 2021/3/31 6:50
 */
public class NO_1124_longest_well_performing_interval_medium {
    public static void main(String[] args) {
        int[] hours = new int[]{1, 2, 3, 4, 5};
        int ret = longestWPI(hours);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 前缀和方法：可以解决区间和的问题
     * <p>
     * Description
     *
     * @Param [hours]
     * @retrun int
     * @since 2021/3/31 6:54
     */
    public static int longestWPI(int[] hours) {
        return 0;
    }
}
