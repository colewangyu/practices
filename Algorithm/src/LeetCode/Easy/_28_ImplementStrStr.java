package LeetCode.Easy;

/**
 * Created by cole on 2016-12-04.
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class _28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            throw new NullPointerException();
        if (needle.length() == 0)
            return 0;

        char[] haystackChar, needleChar;
        boolean isFind;
        haystackChar = haystack.toCharArray();
        needleChar = needle.toCharArray();
        isFind = false;
        int i;
        for (i = -1; i < haystack.length() - needle.length(); ) {
            if (isFind)
                break;
            i++;
            int tmp = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystackChar[tmp] == needleChar[j]) {
                    tmp++;
                    isFind = true;
                    continue;
                } else {
                    isFind = false;
                    break;
                }
            }
        }
        if (isFind)
            return i;
        else
            return -1;
    }
}
