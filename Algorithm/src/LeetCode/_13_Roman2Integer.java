package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cole on 2016-11-05.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * </p>
 * 所有异常情况都会返回0
 */
public class _13_Roman2Integer {
    private static Map<String, Integer> roman = new HashMap();

    static {
        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("D", 500);
        roman.put("CD", 400);
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);
    }

    public int romanToInt(String s) {
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        int oldRoman = 1000;
        int count = 0;
        int tmpRoman;
        String tmp;
        while (sb.length() != 0) {
            if (sb.length() >= 2 && roman.containsKey(tmp = sb.substring(0, 2))) {
                tmpRoman = roman.get(tmp);
                if(oldRoman > tmpRoman) {
                    count = 0;
                    oldRoman = tmpRoman;
                    result += tmpRoman;
                    sb.delete(0, 2);
                } else if(oldRoman < tmpRoman || (oldRoman == tmpRoman && count > 1)) {
                    return 0;
                } else {
                    count++;
                    result += tmpRoman;
                    sb.delete(0, 2);
                }
            } else if (sb.length() >= 1 && roman.containsKey(tmp = sb.substring(0, 1))) {
                tmpRoman = roman.get(tmp);
                if(oldRoman > tmpRoman) {
                    count = 1;
                    oldRoman = tmpRoman;
                    result += tmpRoman;
                    sb.delete(0, 1);
                } else if(oldRoman < tmpRoman || (oldRoman == tmpRoman && count >= 3)) {
                    return 0;
                } else {
                    count++;
                    result += tmpRoman;
                    sb.delete(0, 1);
                }
            } else {
                return 0;
            }
        }
        return result;
    }
}
