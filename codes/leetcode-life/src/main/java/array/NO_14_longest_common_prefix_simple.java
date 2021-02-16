package array;

/**
 * 问题类型：
 * 数学类问题；字符串操作；
 * <p>
 * Description
 * 查找字符串数组中的最长公共前缀。
 * 这道题，解决方法较多
 *
 * @author dave
 * @since 2021/2/13 11:08
 */
public class NO_14_longest_common_prefix_simple {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String ret = longestCommonPrefix_PairCompare(strs);
        System.out.println(ret);
        String[] str2 = {"ab", "a"};
        ret = longestCommonPrefix_PairCompare(str2);
        System.out.println(ret);
    }

    /**
     * 方法1 双循环字符串遍历，字符串同时比较
     * 逐个char的遍历搜索每个strs
     * 始想到，双循环遍历，先比较每个字符串的长度，再判断是否包含；
     * 优化1：两个循环合一，先保存第一个字符串的字符，再取和其他字符串比较
     *
     * @param strs
     * @return 公共串
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ret = new StringBuilder();
        if (strs == null || strs.length < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //长度和index之间差1，字母相同继续，不相同，直接返回上一次的结果
                if (i > strs[j].length() - 1 || strs[j].charAt(i) != c) {
                    return ret.toString();
                }
            }
            ret.append(strs[0].charAt(i));
        }
        return ret.toString();
    }

    /**
     * 方法2 两两比较
     * 先取第一个字符串，拿去逐个比较
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_PairCompare(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;

                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                break;
            }
        }

        return ans;
    }

}
