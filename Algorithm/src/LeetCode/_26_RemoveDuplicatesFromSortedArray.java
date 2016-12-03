package LeetCode;

/**
 * Created by cole on 2016-12-03.
 */
public class _26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            throw new NullPointerException();
        }
        if(nums.length == 0) {
            return 0;
        }
        int result =1;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[i-1]) {

            } else {
                result++;
            }
        }
        return result;
    }
}
