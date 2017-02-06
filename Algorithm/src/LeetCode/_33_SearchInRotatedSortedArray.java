package LeetCode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * You are given a target value to search. If found in the array return its index.The value should be the pivot.
 * </p>
 * <b>In fact, its a binary search problem.</b>
 */
public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length < 1)
            return -1;
        else {
            int index = findNumberIndex(nums, 0, nums.length - 1, target);
            return index;
        }
    }

    /**
     * Find the number, using binary search.
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findNumberIndex(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target)
                return left;
            else return -1;
        } else {
            int result = 0;
            int mid = (right + left) / 2;
            if (left <= mid) result = findNumberIndex(nums, left, mid, target);
            if (result == -1 && mid + 1 <= right) result = findNumberIndex(nums, mid + 1, right, target);
            return result;
        }
    }
}
