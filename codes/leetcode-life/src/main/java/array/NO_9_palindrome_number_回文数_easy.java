package array;

/**
 * 问题类型：
 * 数学类问题；整数操作
 * <p>
 * Description
 * 整数最大回文数
 *
 * @author dave
 * @since 2021/2/10 10:15
 */
public class NO_9_palindrome_number_回文数_easy {

    public static void main(String[] args) {
        boolean ret = isPalindrome2(1001);

    }

    //整数分割，后半部分反转和前部分判断的方法
    //1221 2332 13231 121
    public static boolean isPalindrome(int x) {
        //特殊场景
        //1. x < 0 非回文数
        //2. x==0 是回文数
        //3. x!=0 时末位是0的，是非回文数
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        //一般场景
        //整数后一半数据，反转取数，如果和前一半相等，就是回文数（奇数个位的整数，中间的数据不考虑）;
        //整数分割，进行% / 运算就可以达到目标；分割到一半怎么判断？
        //分割操作过程中，分割剩余的数据不断减少，反转的数据从0不断增加，故停止条件可简单设置为：当分割后的数据小于反转后的数据时停止
        //停止后的场景：
        //剩余的数据= 反转后的数据，是回文数
        //剩余的数据 = 反转后的数据/10 ,是回文数
        //其他场景，不是回文数

        int halfLow = 0;
        while (x > halfLow) {
            halfLow = halfLow * 10 + x % 10;
            x = x / 10;
        }
        if (x == halfLow || x == halfLow / 10) {
            return true;
        }

        return false;
    }

    //整数 按位比较方法
    public static boolean isPalindrome2(int x) {
        //特殊场景
        //1. x < 0 非回文数
        //2. 0<=x<10 是回文数
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }


        //一般场景
        //高位和低位的数据逐位比较
        //低位可以通过逐步取%获取到，最高位怎么取？
        //高位需要一个循环，获取10的幂
        //其他高位怎么取，最高位的除数找到，后面的就好找了；

        int div = 1;
        int temp = x / 10;
        while (x / div >= 10) {// 22 ->10 ; 221->100
            div *= 10;
        }

        int top = x / div;
        int bottom = x % 10;
        while (div >= 10) {
            if (top != bottom) {
                return false;
            }
            x = (x % div) / 10;//技巧1：两头比较后的剩余数据；
            div /= 100;//技巧2：只比较一半数据的方法；
            if (div == 0) {
                break;
            }
            top = x / div;
            bottom = x % 10;
        }

        return true;
    }
}
