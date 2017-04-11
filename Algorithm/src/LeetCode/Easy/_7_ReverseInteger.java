package LeetCode.Easy;

/**
 * Created by cole on 2016-10-31.
 */
public class _7_ReverseInteger {
    /**
     * 将Integer类型的数字进行倒置,异常情况返回0
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 1.将Intger的转为String
        String s = String.valueOf(x);
        StringBuffer result = new StringBuffer();

        int bottom = 0;
        // 2.判断第一位是否有负号,有负号则先处理负号
        if (s.charAt(0) == '-') {
            result.append('-');
            bottom++;
        }

        // 3.依次添加其他数字
        for (int i = s.length() - 1; i >= bottom; i--) {
            result.append(s.charAt(i));
        }

        try {
            return Integer.valueOf(result.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
