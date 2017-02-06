package LeetCode;

/**
 * Created by wy on 2017-02-06.
 */
public class _35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
