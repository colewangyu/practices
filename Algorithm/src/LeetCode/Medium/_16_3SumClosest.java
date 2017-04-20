package LeetCode.Medium;

import java.util.Arrays;

/**
 * Created by cole on 2016-11-16.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 有效性验证
        if (nums == null) throw new NullPointerException();
        if (nums.length < 3) throw new IllegalArgumentException();

        int result = 0;
        int left, right;
        int tmpResult;
        int tmpDist;
        int minDist = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                // 尽可能接近tmpTarget
                tmpResult = nums[i] + nums[left] + nums[right];
                tmpDist = tmpResult - target;
                if (tmpDist > 0) {
                    right--;
                } else if (tmpDist < 0) {
                    left++;
                } else {
                    return tmpResult;
                }
                tmpDist = Math.abs(tmpDist);
                if (tmpDist < minDist) {
                    minDist = tmpDist;
                    result = tmpResult;
                }
            }
        }
        return result;
    }
}
