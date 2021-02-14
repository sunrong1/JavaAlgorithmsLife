package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dave
 * // I             1
 * // V             5
 * // X             10
 * // L             50
 * // C             100
 * // D             500
 * // M             1000
 * //
 * //大的数，除特殊场景放在小数的左边
 * // 特殊场景:
 * // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * // 输入确保在 1 到 3999 的范围内
 * // 来源：力扣（LeetCode）
 * // 链接：https://leetcode-cn.com/problems/roman-to-integer
 */
public class NO_13_roman_to_integer_simple {
  public static void main(String[] args) {
    //LVIII = 50 + 5+ 3
    //MCMXCIV = 1000 + 900 + 90 + 4
    int ret = romanToInt("MCMXCIV");
    System.out.println(ret);
    ret = romanToIntMathLogic("MCMXCIV");
    System.out.println(ret);
  }

  //字典遍历取值法
  public static int romanToInt(String s) {

    //对于字母到数字的映射，首先想到的是Switch，但是有没有效率更高的存储方式
    //map 字典存储的方式效率更高。

    Map<String, Integer> stringIntegerMap = new HashMap<String, Integer>();
    stringIntegerMap.put("I", 1);
    stringIntegerMap.put("V", 5);
    stringIntegerMap.put("X", 10);
    stringIntegerMap.put("L", 50);
    stringIntegerMap.put("C", 100);
    stringIntegerMap.put("D", 500);
    stringIntegerMap.put("M", 1000);
    stringIntegerMap.put("IV", 4);
    stringIntegerMap.put("IX", 9);
    stringIntegerMap.put("XL", 40);
    stringIntegerMap.put("XC", 90);
    stringIntegerMap.put("CD", 400);
    stringIntegerMap.put("CM", 900);

    int sum = 0;

    //逻辑需要思考清晰：
    //要点：从大数到小数取数，即从字符串左到右取
    //循环的index需要控制，字典里面存在两个的就先进行两个字母数据的转换，否则一个
    for (int i = 0; i < s.length(); ) {
      String temp = "";
      if ((i + 2 < s.length() + 1)) {
        temp = s.substring(i, i + 2);
        if (stringIntegerMap.get(temp) != null) {
          i += 2;
        } else {
          temp = "";
        }
      }
      if (temp == "") {
        temp = s.substring(i, i + 1);
        i++;
      }
      sum += stringIntegerMap.get(temp);

    }
    return sum;
  }


  /**
   * 数学规律取值法
   * 可以一个个字母转换数字相加，当前面的数字小于后面的字母，减去前面字母即可
   */
  public static int romanToIntMathLogic(String s) {
    int sum = 0;
    Map<Character, Integer> stringIntegerMap = new HashMap<Character, Integer>();
    stringIntegerMap.put('I', 1);
    stringIntegerMap.put('V', 5);
    stringIntegerMap.put('X', 10);
    stringIntegerMap.put('L', 50);
    stringIntegerMap.put('C', 100);
    stringIntegerMap.put('D', 500);
    stringIntegerMap.put('M', 1000);
    // 前面代表的数字
    int preNum = 0;
    for (int i = 0; i < s.length(); i++) {
      int currentNum = stringIntegerMap.get(s.charAt(i));
      if (currentNum > preNum) {
        //实际的数字 - 前面一次多加的
        sum += currentNum - preNum - preNum;
      } else {
        sum += currentNum;
      }
      preNum = currentNum;

    }

    return sum;
  }
}
