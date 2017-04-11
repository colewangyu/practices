package LeetCode.Medium;

import java.util.*;

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map;
        if(strs ==null || strs.length == 0)
            return new ArrayList<List<String>>();
        else {
            map = new HashMap<String, List<String>>();
            for(String s : strs) {
                char[] chrs = s.toCharArray();
                Arrays.sort(chrs);
                String tmp = String.valueOf(chrs);
                if(map.containsKey(tmp)) {
                    map.get(tmp).add(s);
                } else {
                    List<String> tmpList = new ArrayList<String>();
                    tmpList.add(s);
                    map.put(tmp, tmpList);
                }
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
