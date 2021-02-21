package string;

/**
 * 问题类型：
 * 字符串搜索问题，滑动窗口，KMP算法
 * <p>
 * Description
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
 *
 * @author dave
 * @since 2021/2/21 9:19
 */
public class NO_28_implement_strstr_easy {

    public static void main(String[] args) {
//        String input = "hell";
//        String needle = "ll";

        String input = "a";
        String needle = "";
        int ret = strStr(input, needle);
        System.out.println(ret);
    }

    /**
     * 方法1：
     * 滑动窗口，暴力解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int length = needle.length();
        //i是数组下标，i的循环条件，是可以截取的字符串大于等于needle的长度
        for (int i = 0; i <= haystack.length() - length; i++) {
//            //优化1：当字符串首字母相同时，再切割比较；因为右较多的特殊场景处理，这个优化不好加
//            if (haystack.charAt(i) != needle.charAt(0)) {
//                continue;
//            }

            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法2：
     * 滑动窗口，双指针法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr_doublePointer(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int length = needle.length();
        //i是数组下标，i的循环条件，是可以截取的字符串大于等于needle的长度

        return -1;
    }
}
