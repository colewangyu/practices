package LeetCode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int tmp;
        int sum;
        tmp = nums[0];
        sum = tmp;
        for (int i = 1; i < nums.length; i++) {
            if (tmp <= 0) {
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
            if (tmp > sum) sum = tmp;
        }
        return sum;
    }
}
