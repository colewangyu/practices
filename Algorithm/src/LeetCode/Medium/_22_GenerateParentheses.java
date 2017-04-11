package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016-11-29.
 */
public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result;
        result = new ArrayList<String>();

        generateRecursion(result, n, n, 2 * n, new StringBuilder());
        return result;
    }

    private void generateRecursion(List<String> result, int leftNum, int rightNum, int num, StringBuilder s) {
        if (num == 0) {
            result.add(s.toString());
            return;
        }
        StringBuilder tmp = new StringBuilder(s);
        if (leftNum > 0)
            generateRecursion(result, leftNum - 1, rightNum, num - 1, tmp.append("("));

        tmp = new StringBuilder(s);
        if (rightNum > 0 && leftNum < rightNum)
            generateRecursion(result, leftNum, rightNum - 1, num - 1, tmp.append(")"));
    }
}
