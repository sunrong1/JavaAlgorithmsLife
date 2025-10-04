package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaAlgorithmsLife
 * @description: 赎金信
 * @author: dave
 * @create: 2025/9/29 13:25
 **/
public class NO_383_ransomnote_easy {
    public static void main(String[] args) {
        String ransomNote= "a";
        String magazine= "aab";
        System.out.println(canConstruct1(ransomNote,magazine));
    }

    /**
     * 方法2，使用简单数据实现，根据数据特点
     * @param ransomNote
     * @param magazine
     * @return
     */
    private static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //数据的特点，一共就只有26个小写字母
        int[] mm = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mm[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            mm[ransomNote.charAt(i) - 'a']--;
            if (mm[ransomNote.charAt(i) - 'a'] < -0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 一般方法，使用map集合进行存储和获取通用字符
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        //扫描两次，magazine 进行哈希表扫描，然后ransonnote从哈希表中取
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (map.get(magazine.charAt(i)) == null) {
             map.put(magazine.charAt(i),1);
            }
            else {
                //记录magazine每个字符出现的次数
                map.put(magazine.charAt(i),map.get(magazine.charAt(i)) +1);
            }
        }
        //ransomNote逐个从map中取字符，如果小于0或者不存在返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.get(ransomNote.charAt(i)) == null) {
                return false;
            }
            else {
                //记录magazine每个字符出现的次数
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i)) - 1);
                if (map.get(ransomNote.charAt(i)) < 0) {
                    return false;
                }
            }
        }


        return true;
    }
}
