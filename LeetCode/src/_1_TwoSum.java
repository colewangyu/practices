import java.util.HashMap;
import java.util.Map;

/**
 * Created by cole on 2016-04-30 Saturday.
 * <p/>
 * Introduce:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        System.out.println(new _1_TwoSum().twoSum_HashTable(new int[]{0,4,3,0},0));
    }
    /**
     * 暴力解决法
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     *
     * @param nums   用于匹配的数组
     * @param target 目标和
     * @return 匹配上的两个数的下标数组
     */
    public int[] twoSum_BruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("无对应的两个数!");
    }

    /**
     * HashTable解决
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param nums   用于匹配的数组
     * @param target 目标和
     * @return 匹配上的两个数的下标数组
     */
    public int[] twoSum_HashTable(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 1; j < nums.length; j++) {
            int gap = target - nums[j];
            if (map.containsKey(gap) && map.get(gap) != j) {
                if (map.get(gap) > j) {
                    result[0] = j;
                    result[1] = map.get(gap);
                } else {
                    result[0] = map.get(gap);
                    result[1] = j;
                }
                return result;
            }
        }
        throw new IllegalArgumentException("无对应的两个数!");
    }
}
