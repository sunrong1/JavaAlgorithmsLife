package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 * 只要我们可以通过交换 A字符串中的两个字母得到与 B 相等的结果，就是亲密字符串 ；否则不少 。
 * 两个由小写字母构成的字符串
 *
 * @author dave
 * @since 2021/3/15 7:04
 */
public class NO_859_buddy_strings_easy {

    public static void main(String[] args) {

        String input = "ab";
        String input1 = "ba";
        boolean ret = buddyStrings(input, input1);
        System.out.println(ret);
    }

    public static boolean buddyStrings(String a, String b) {
        //第一种情况
        if (a.length() != b.length()) {
            return false;
        }
        //第二种情况，如果a，b相等，只要有一个字母重复即可
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        if (a.equals(b)) {
            for (int i = 0; i < a.length(); i++) {
                if (!set.add(a.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        //第三种情况：a，b 不相等，a[i] == b[j] && a [j] = b[i]
        //i:找到的第一个不相等的位置
        int i = 0;
        while (a.charAt(i) == b.charAt(i)) {
            i++;
        }
        //j:找到的第二个不相等的位置
        int j = i + 1;
        while (j < a.length() && a.charAt(j) == b.charAt(j)) {
            j++;
        }
        if (j == a.length()) {
            return false;
        }
        //i j 位置互换必须相等，否则false
        if (a.charAt(i) != b.charAt(j) || a.charAt(j) != b.charAt(i)) {
            return false;
        }
        //剩下的字符串必须相等，否则false
        j++;
        while (j < a.length()) {
            if (a.charAt(j) != b.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }
}
