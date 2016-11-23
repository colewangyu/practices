package LeetCode;

import java.util.*;

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

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 求两数和等于sum
            twoSum(nums, resultList, -nums[i], i, nums.length - 1);
        }

//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        Iterator<Integer> it = map.keySet().iterator();
//        for (; it.hasNext(); ) {
//            // 求两数和等于sum
//            twoSum(resultList, map, -it.next());
//        }
        return resultList;
    }

    private void twoSum(int[] nums, List<List<Integer>> resultList, int target, int start, int end) {
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

    // TODO: 2016-11-15
    private void twoSum(List<List<Integer>> resultList, Map<Integer, Integer> numsMap, int target) {
        int count = 1;
        int tmp;
        List<Integer> listTmp;

        Iterator<Integer> it = numsMap.keySet().iterator();
        for (; it.hasNext(); ) {
            tmp = it.next();
            if (tmp == -target) {
                if (numsMap.get(tmp) > count)
                    count++;
                else
                    continue;
            }
            if (tmp == target - tmp) {
                if (numsMap.get(tmp) > count)
                    count++;
                else
                    continue;
            }
            if (numsMap.containsKey(target - tmp)) {
                listTmp = new ArrayList<Integer>();
                listTmp.add(-target);
                listTmp.add(tmp);
                listTmp.add(target - tmp);
                resultList.add(listTmp);
            }
        }
    }


}
