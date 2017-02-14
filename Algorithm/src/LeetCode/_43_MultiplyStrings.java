package LeetCode;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 【解题思路】使用数组来保存结果,第一次将两个String数中的任意两位两两相乘,并保存结果到结果数组中,然后依次进位,得到结果
 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder resultString;
        int[] resultArr;
        char[] num1Arr, num2Arr;

        num1Arr = num1.toCharArray();
        num2Arr = num2.toCharArray();
        resultArr = new int[num1Arr.length + num2Arr.length];
        for (int i = 0; i < resultArr.length; i++)
            resultArr[i] = 0;

        // 两数的各个位上的数,两两相乘
        for (int i = 0; i < num1Arr.length; i++) {
            for (int j = 0; j < num2Arr.length; j++) {
                resultArr[i + j + 1] += (num1Arr[i] - 48) * (num2Arr[j] - 48);
            }
        }

        // 进行进位
        int decade, unit;
        for (int i = resultArr.length - 1; i > 0; i--) {
            decade = resultArr[i] / 10;
            unit = resultArr[i] % 10;
            resultArr[i - 1] += decade;
            resultArr[i] = unit;
        }

        resultString = new StringBuilder();
        int index;
        index = 0;
        // 处理首位
        if(resultArr[0] == 0)
            index = 1;
        for (; index < resultArr.length; index++) {
            resultString.append(resultArr[index]);
        }
        return resultString.toString();
    }
}
