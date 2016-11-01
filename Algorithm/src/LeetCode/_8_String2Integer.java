package LeetCode;

/**
 * Created by cole on 2016-11-01.
 */
public class _8_String2Integer {
    /**
     * 【作用】将String类型转换成Integer类型
     * 【输入】任意String类型
     * 【异常】返回0
     * <p>
     * 无效输入
     * 1. 输入为空
     * 2. 输入为""
     * 3. 输入包含非数字
     * 4. 输入超出整形范围
     * 5. 输入只有符号
     * 有效输入
     * 1. 输入正数(可以带正号,也可以省略正号)
     * 2. 输入负数(必须带负号)
     * 3. 输入0
     * 4. 输入为边界值
     * 5. 输入前面一位或多位为0
     * 6. 输入前面有一个或多个空格
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        // null或""判断
        if (str == null || str.length() == 0)
            return 0;

        int index = 0;
        boolean isNegative = false;
        int limit = Integer.MAX_VALUE;
        int tmpLimit;
        int digit;
        int result = 0;
        char tmpChr;


        // 遍历str中的第一个非空格的char,判断符号
        while (str.charAt(index) == ' ') {
            index++;
        }
        tmpChr = str.charAt(index);
        if (tmpChr == '-') {
            index++;
            isNegative = true;
            limit = Integer.MIN_VALUE;
        } else if (tmpChr == '+') {
            index++;
        }
        // 处理只有"+"或"-"的情况。
        if (index == str.length()) {
            return 0;
        }

        // 逐一处理后面的char
        // 处理边界值使用负数,因为最小值的绝对值比最大值大
        limit = limit < 0 ? limit : -limit;
        tmpLimit = limit / 10;
        boolean willReturn = false;
        for (; index < str.length(); index++) {
            tmpChr = str.charAt(index);
            if (tmpChr <= '9' && tmpChr >= '0') {
                willReturn = true;
                digit = tmpChr - 48;
                // 确保result乘10不会超范围
                if (result < tmpLimit) {
                    // 超范围设值为边界值
                    result = limit;
                    break;
                }
                result *= 10;
                // 确保result-digit不会超范围
                if (result < limit + digit) {
                    // 超范围设值为边界值
                    result = limit;
                    break;
                }
                result -= digit;
            } else if (willReturn) {
                break;
            } else {
                // 异常退出
                return 0;
            }
        }
        return isNegative ? result : -result;
    }
}
