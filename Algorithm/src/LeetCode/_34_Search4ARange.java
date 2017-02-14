package LeetCode;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p/>
 * 【解题思路】找到第一个比target小和比target大的数
 */
public class _34_Search4ARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int left, right;
        left = 0;
        right = nums.length - 1;
        binarySearch(nums, left, right, target, result, true, true);
        return result;
    }

    /**
     * 标记的二分查找法
     *
     * @param nums 排序的数组
     * @param left 左边界下标
     * @param right 右边界下标
     * @param target 查找目标
     * @param result 查找结果
     * @param isLeft 标记是否往目标左边查找
     * @param isRight 标记是否往目标右边查找
     */
    private void binarySearch(int[] nums, int left, int right, int target, int[] result, boolean isLeft, boolean isRight) {
        // 退出条件
        if(left > right)
            return;

        int middle = (left + right) / 2;

        if (nums[middle] > target) {
            // 当前数比目标大，递归往左边查找
            binarySearch(nums, left, middle - 1, target, result, isLeft, isRight);
        } else if (nums[middle] < target) {
            // 当前数比目标小，递归往右边查找
            binarySearch(nums, middle+1, right, target, result, isLeft, isRight);
        } else {
            // 相同则进行结果修改
            if (isLeft)
                result[0] = middle;
            if (isRight)
                result[1] = middle;
            if (isLeft && isRight) {
                binarySearch(nums, left, middle - 1, target, result, true, false);
                binarySearch(nums, middle + 1, right, target, result, false, true);
            } else if(isLeft) {
                binarySearch(nums, left, middle - 1, target, result, isLeft, isRight);
            } else {
                binarySearch(nums, middle + 1, right, target, result, isLeft, isRight);
            }
        }
    }
}
