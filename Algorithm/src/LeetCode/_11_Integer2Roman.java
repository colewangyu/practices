package LeetCode;

/**
 * Created by cole on 2016-11-05.
 * <p>
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * </p>
 */
public class _11_Integer2Roman {
    public String intToRoman(int num) {
        if(num < 0 || num > 3999)
            return "";

        // 整数
        int integer;
        // 余数
        int remainder;
        // roman数字
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) {
                result.append(roman[0]);
                num -= 1000;
            } else if (num >= 900) {
                result.append(roman[1]);
                num -= 900;
            } else if (num >= 500) {
                result.append(roman[2]);
                num -= 500;
            } else if (num >= 400) {
                result.append(roman[3]);
                num -= 400;
            } else if (num >= 100) {
                result.append(roman[4]);
                num -= 100;
            } else if (num >= 90) {
                result.append(roman[5]);
                num -= 90;
            } else if (num >= 50) {
                result.append(roman[6]);
                num -= 50;
            } else if (num >= 40) {
                result.append(roman[7]);
                num -= 40;
            } else if (num >= 10) {
                result.append(roman[8]);
                num -= 10;
            } else if (num >= 9) {
                result.append(roman[9]);
                num -= 9;
            } else if (num >= 5) {
                result.append(roman[10]);
                num -= 5;
            } else if (num >= 4) {
                result.append(roman[11]);
                num -= 4;
            } else if (num >= 1) {
                result.append(roman[12]);
                num -= 1;
            }
        }
        return result.toString();
    }
}
