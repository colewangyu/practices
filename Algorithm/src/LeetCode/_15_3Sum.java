package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wy on 2016-11-13.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        // 数据有效性判断
        if (nums.length < 3) return resultList;

        // 排序
        Arrays.sort(nums);

        int sum;
        int twoSum;
        List<Integer> tmpList;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            sum = -nums[i];
            // 求两数和等于sum
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                twoSum = nums[left] + nums[right];
                if (twoSum > sum) {
                    right--;
                } else if (twoSum < sum) {
                    left++;
                } else {
                    tmpList = new ArrayList<Integer>();
                    if (i < left) {
                        tmpList.add(nums[i]);
                        tmpList.add(nums[left]);
                        tmpList.add(nums[right]);
                    } else if (left < i && i < right) {
                        tmpList.add(nums[left]);
                        tmpList.add(nums[i]);
                        tmpList.add(nums[right]);
                    } else {
                        tmpList.add(nums[left]);
                        tmpList.add(nums[right]);
                        tmpList.add(nums[i]);
                    }
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    resultList.add(tmpList);
                }
            }
        }
        return resultList;
    }
}
