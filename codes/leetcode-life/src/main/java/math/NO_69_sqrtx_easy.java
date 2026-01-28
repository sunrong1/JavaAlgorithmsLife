package math;

/**
 * 问题类型：二分查找
 * 数学问题，
 * <p>
 * Description
 * 实现 int sqrt(int x) 函数,只返回整数部分
 *
 * @author dave
 * @since 2021/2/21 15:03
 */
public class NO_69_sqrtx_easy {
    public static void main(String[] args) {
        int input = 16;
        int ret = mySqrt(input);
        System.out.println(ret);
    }

    private static int mySqrt(int x) {
        if (x <=1){
            return 0;
        }
        int l = 1;
        int r = x;
        while (l < r){
            int mid = (l+r)>>1;
            if (mid * mid > x){
                r = mid;
            }
            else if (mid * mid < x){
                l = mid;
            }
            else {
                return mid;
            }
            if (r -l ==1){
                return l;
            }
        }
        return 0;

    }

}
