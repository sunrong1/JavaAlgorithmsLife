package math;

/**
 * 问题类型：
 * 小贪心问题
 * <p>
 * Description
 * 5 美元、10 美元或 20 美元的钱去买柠檬水，找钱的问题
 *
 * @author dave
 * @since 2021/3/17 20:42
 */
public class NO_860_lemonade_change_easy {
    public static void main(String[] args) {
        int[] input = new int[]{5, 5, 10, 10, 20};
        boolean ret = lemonadeChange(input);
        System.out.println(ret);
    }

    /**
     * 小贪心方法，每次尽量找给大钱，才是最优解
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        //存储两种类型钱的数量，20的根本用不了
        int fiveNum = 0;
        int tenNum = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                if (fiveNum > 0) {
                    fiveNum--;
                    tenNum++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (tenNum > 0) {
                    if (fiveNum == 0) {
                        return false;
                    } else {
                        tenNum--;
                        fiveNum--;
                    }
                } else if (fiveNum >= 3) {
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
