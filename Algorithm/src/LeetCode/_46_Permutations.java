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
 * <p/>
 * 【解题思路】使用递归遍历每一种组合，每次加入一个数就从临时表中删除该数
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result;
        result = new ArrayList<List<Integer>>();

        findPermutations(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void findPermutations(int[] nums, int curIndex, ArrayList<Integer> tmpResult, List<List<Integer>> result) {
        if (curIndex >= nums.length) {
            result.add(tmpResult);
            return;
        } else {
            ArrayList<Integer> tmpList;
            for (int i = 0; i <= tmpResult.size(); i++) {
                tmpList = new ArrayList<Integer>();
                tmpList.addAll(tmpResult);
                tmpList.add(i, nums[curIndex]);
                findPermutations(nums, curIndex + 1, tmpList, result);
            }
        }
    }
}
