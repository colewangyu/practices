package LeetCode.Easy;

/**
 * Created by wy on 2016-11-14.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //输入有效性判断
        if (strs == null) throw new NullPointerException();
        if (strs.length == 0) return "";
        //声明相关值
        char c;
        StringBuffer sb;
        sb = new StringBuffer();
        //遍历第一个字符串的每个字母
        for (int i = 0; i < strs[0].length(); i++) {
            c = strs[0].charAt(i);
            //第二层遍历每个字符串的对应位置
            for (int j = 1; j < strs.length; j++) {
                //判断字符串的对应字符是否相等
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
