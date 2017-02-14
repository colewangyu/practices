package LeetCode;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p/>
 * 解题方法：从右往左依次寻找，找到第一个比自己小的数进行对调，如果个位找不到，则从十位往左继续寻找。互换过后，被换的那个数的右边按从小到大排序即可。
 *
 * 一种更好的解题方法：1. 从右往左，找到第一个递增的两个相邻的数；2. 从右往左，找到第一个比相邻数左边那个数更大的数，交换这两个数；3. 从相邻数右边那个数到数组最右边，进行收尾交换。
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int tailIndex = nums.length - 1;
        if (tailIndex < 1)
            return;

        int leftIndex = -1, rightIndex = -1;
        for (int i = tailIndex; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                   if(j > leftIndex) {
                       leftIndex = j;
                       rightIndex = i;
                   }
                }
            }
        }
        if(leftIndex != -1) {
            // 更换两数
            swap(nums, leftIndex, rightIndex);
            // 被更换数的右边的数重新排序
            Arrays.sort(nums, leftIndex + 1, nums.length);
        } else {
            // 没有更换，重新按正序排列
            Arrays.sort(nums);
        }
        return;
    }

    private void swap(int[] nums, int thisOne, int otherOne) {
        nums[thisOne] = nums[thisOne] ^ nums[otherOne];
        nums[otherOne] = nums[thisOne] ^ nums[otherOne];
        nums[thisOne] = nums[thisOne] ^ nums[otherOne];
    }
}
