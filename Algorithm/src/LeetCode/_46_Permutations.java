package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * <p/>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * 【解题思路】使用递归遍历每一种组合，每次加入一个数就从临时表中删除该数
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result;
        result = new ArrayList<List<Integer>>();

        HashSet<Integer> numsSet;
        numsSet = new HashSet<Integer>();
        for(int i : nums) {
            numsSet.add(i);
        }

        findPermutations(numsSet, new ArrayList<Integer>(),  result);
        return result;
    }

    private void findPermutations(HashSet<Integer> nums, ArrayList<Integer> tmpResult, List<List<Integer>> result) {
        if(nums.size() == 0) {
            result.add(tmpResult);
        } else {
            int tmpInteger;
            ArrayList<Integer> tmpList;
            HashSet<Integer> tmpNums;
            Iterator<Integer> it = nums.iterator();
            while(it.hasNext()) {
                tmpInteger = it.next();
                tmpNums = new HashSet<Integer>();
                tmpNums.addAll(nums);
                tmpNums.remove(tmpInteger);
                tmpList = new ArrayList<Integer>();
                tmpList.addAll(tmpResult);
                tmpList.add(tmpInteger);
                findPermutations(tmpNums, tmpList, result);
            }
        }
    }
}
