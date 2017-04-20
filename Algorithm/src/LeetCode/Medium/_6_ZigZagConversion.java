package LeetCode.Medium;

/**
 * Created by cole on 2016-10-30.
 */
public class _6_ZigZagConversion {
    /**
     * 按照如下规则进行输出:
     * 示例:
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * 输入: PAYPALISHIRING, 3
     * 输出: PAHNAPLSIIGYIR
     *
     * P    I    N
     * A  L S  I G
     * Y A  H R
     * P    I
     *
     * 输入: PAYPALISHIRING, 3
     * 输出:PINALSIGYAHRPI
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuffer();
        }
        int index = 0;
        boolean direction = true;
        for(int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if(direction) index++;
            else index--;
            if(index == numRows && direction) {
                index = numRows - 2;
                direction = false;
            } else if(index == -1 && !direction) {
                index = 1;
                direction = true;
            }
            if(index >= numRows || index < 0)
                index = 0;
        }
        for(StringBuffer sb : sbs) {
            result.append(sb);
        }
        return result.toString();
    }
}
