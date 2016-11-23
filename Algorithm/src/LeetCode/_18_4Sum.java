package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cole on 2016-11-23.
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        // 数据有效性判断
        if (nums.length < 4) return resultList;

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                // 与上一个数比较,保证重复的数只被判断一次,但循环的第一次判断除外
                continue;
            threeSum(nums, i, target - nums[i], resultList);
        }
        return resultList;
    }

    private void threeSum(int[] nums, int start, int target, List<List<Integer>> resultList) {

        for (int i = start + 1; i < nums.length - 2; i++) {
            if (i > start + 1 && nums[i] == nums[i - 1])
                // 与上一个数比较,保证重复的数只被判断一次,但循环的第一次判断除外
                continue;
            // 求两数和等于sum
            twoSum(nums, resultList, target - nums[i], i, nums.length - 1, nums[start]);
        }

    }

    private void twoSum(int[] nums, List<List<Integer>> resultList, int target, int start, int end, int first) {
        int twoSum;
        List<Integer> tmpList;
        int left = start + 1, right = end;
        while (left < right) {
            twoSum = nums[left] + nums[right];
            if (twoSum > target) {
                right--;
            } else if (twoSum < target) {
                left++;
            } else {
                tmpList = new ArrayList<Integer>();
                tmpList.add(first);
                tmpList.add(nums[start]);
                tmpList.add(nums[left]);
                tmpList.add(nums[right]);
                resultList.add(tmpList);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right > left && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}
