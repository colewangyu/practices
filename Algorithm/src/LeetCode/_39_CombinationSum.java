package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * <p>
 * 【解题思路】使用递归,遍历所有可能。
 */
public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result;

        result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        findNextNumber(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void findNextNumber(int[] candidates, int target, int startIndex, List<Integer> tmpResult, List<List<Integer>> result) {
        List<Integer> tmp;

        // Quit condition
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(tmpResult);
            return;
        } else {
            // Iterator candidates to satisfy every possibility.
            for (int i = startIndex; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    tmp = new ArrayList<Integer>();
                    tmp.addAll(tmpResult);
                    tmp.add(candidates[i]);
                    findNextNumber(candidates, target - candidates[i], i, tmp, result);
                } else {
                    return;
                }
            }
        }
    }
}
