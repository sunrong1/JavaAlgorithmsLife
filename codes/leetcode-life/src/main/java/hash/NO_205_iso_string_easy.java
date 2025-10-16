package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaAlgorithmsLife
 * @description: 同构字符串
 * @author: dave
 * @create: 2025/10/4 12:15
 **/
public class NO_205_iso_string_easy {
    public static void main(String[] args) {
        String s= "bba";
        String t= "aab";
        System.out.println(isIsomorphic1(s,t));
    }

    /**
     * 方法2：使用2个map，直接构建s 和t的相互映射关系
     * 效率更高
     * @param s
     * @param t
     * @return
     */
    private static boolean isIsomorphic1(String s, String t) {
        //不相等，肯定不一样
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Character> maps = new HashMap<>();
        Map<Character,Character> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character ss = s.charAt(i);
            Character tt = t.charAt(i);
            if (maps.containsKey(ss) && maps.get(ss) != tt){
                return false;
            }
            if (mapt.containsKey(tt) && mapt.get(tt) != ss){
                return false;
            }
            maps.put(ss,tt);
            mapt.put(tt,ss);
        }
        return true;
    }

    /**
     * 方法1：通过记录计算
     * 使用2个map，计算距离，双向映射的距离都是相等的，就说明是一致的
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        //不相等，肯定不一样
        if (s.length() != t.length()) {
            return false;
        }
        //从左到右遍历距离，更新或者check
        Map<Character,Integer>  maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapt.get(s.charAt(i)) == null) {
                mapt.put(s.charAt(i),s.charAt(i) -t.charAt(i));
            }
            else {
                if (mapt.get(s.charAt(i)) != s.charAt(i) - t.charAt(i)) {
                    return false;

                }
            }

            if (maps.get(t.charAt(i)) == null) {
                maps.put(t.charAt(i),s.charAt(i) -t.charAt(i));
            }
            else {
                if (maps.get(t.charAt(i)) != s.charAt(i) - t.charAt(i)) {
                    return false;

                }
            }
        }

        return true;
    }
}
