package LeetCode;

/**
 * Created by cole on 2016-10-31.
 */
public class _7_ReverseInteger {
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

        return Integer.valueOf(result.toString());
    }
}
