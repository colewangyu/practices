package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016-11-22.
 */
public class _17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        // 输入有效性判断
        if (digits == null)
            throw new NullPointerException();
        if(digits.length() == 0)
            return new ArrayList<String>();

        List<String> result;
        char[] middleResult;
        String[] numberMap;

        result = new ArrayList<String>();
        middleResult = new char[digits.length()];
        numberMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        DFS(digits, 0, middleResult, numberMap, result);
        return result;
    }

    private void DFS(String digits, int index, char[] middleResult, String[] numberMap, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(middleResult));
            return;
        }
        char tmpChar = digits.charAt(index);
        if ((tmpChar > '9' || tmpChar < '0') && tmpChar != '#' && tmpChar != '*') {
            // 超出电话输入范围
            throw new IllegalArgumentException();
        } else if (tmpChar == '*' || tmpChar == '#') {
            DFS(digits, index + 1, middleResult, numberMap, result);
        } else {
            for (int i = 0; i < numberMap[tmpChar - '0'].length(); i++) {
                middleResult[index] = numberMap[tmpChar - '0'].charAt(i);
                DFS(digits, index + 1, middleResult, numberMap, result);
            }
        }
    }
}
