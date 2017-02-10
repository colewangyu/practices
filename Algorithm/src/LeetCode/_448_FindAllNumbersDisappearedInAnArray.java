package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class _448_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result;
        result = new ArrayList<Integer>();

        if (nums.length > 1) {
            Set<Integer> container;
            container = new HashSet<Integer>();

            for(int i = 0; i < nums.length; i++) {
                container.add(nums[i]);
            }

            for(int i = 1; i <= nums.length; i++) {
                if(container.contains(i)) {
                    continue;
                } else {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
