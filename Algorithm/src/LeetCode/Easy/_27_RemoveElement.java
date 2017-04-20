package LeetCode.Easy;

import java.util.ArrayList;

/**
 * Created by cole on 2016-12-04.
 * <p>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null)
            throw new NullPointerException();

        int result;
        int index;
        result = 0;
        index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            } else {
                nums[index++] = nums[i];
                result++;
            }
        }
        return result;
    }
}
