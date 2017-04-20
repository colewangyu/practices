package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * 【解题思路】使用递归,每一层递归遍历nums中的所有数,在未使用过的数中,对不同的数均进行递归
 */
public class _47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result;
        result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        for(int i = 0 ; i < used.length; i++) {
            used[i] = false;
        }
        findPermuteUnique(nums, used, new ArrayList<Integer>(), result);
        return result;
    }

    private void findPermuteUnique(int[] nums, boolean[] used, List<Integer> tmpResult, List<List<Integer>> result) {
        if (nums.length == tmpResult.size()) {
            result.add(tmpResult);
            return;
        } else {
            List<Integer> tmpList;
            HashSet<Integer> usedThisTurn;
            boolean[] tmpUsed;

            usedThisTurn = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if(!used[i] && !usedThisTurn.contains(nums[i])) {
                    usedThisTurn.add(nums[i]);
                    tmpUsed = used.clone();
                    tmpUsed[i] = true;
                    tmpList = new ArrayList<Integer>();
                    tmpList.addAll(tmpResult);
                    tmpList.add(nums[i]);
                    findPermuteUnique(nums, tmpUsed, tmpList,result);
                }else{
                    continue;
                }
            }
        }
    }

}
