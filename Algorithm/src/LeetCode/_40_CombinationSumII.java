package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * <p/>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p/>
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * <p/>
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result;
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findNextNumber(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void findNextNumber(int[] sortedCandidates, int target, int startIndex, List<Integer> tmpResult, List<List<Integer>> result) {
        int tmpTarget;
        List<Integer> tmp;

        for (int i = startIndex; i < sortedCandidates.length; i++) {
            if (i > startIndex && sortedCandidates[i] == sortedCandidates[i - 1]) // 保证同一个值只进行一次递归，避免输入为{2,2,2},4时，第1、2个2，第2、3个2重复。
                continue;
            tmpTarget = target - sortedCandidates[i];
            if (tmpTarget == 0) {
                tmpResult.add(sortedCandidates[i]);
                result.add(tmpResult);
                return;
            } else if (tmpTarget > 0) {
                tmp = new ArrayList<Integer>();
                tmp.addAll(tmpResult);
                tmp.add(sortedCandidates[i]);
                findNextNumber(sortedCandidates, tmpTarget, i + 1, tmp, result);
            } else {
                return;
            }
        }
    }
}
