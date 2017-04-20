package LeetCode.Medium;

/**
 * Created by wy on 2016-11-03.
 * [describe]
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 */
public class _11_ContainerWithMostWater {
    /*
    有效输入：
    1. 等高
    2. 中间高
    3. 两边高
    4. 递增
    5. 递减
    6. W型
    7. M型
    8. 仅有两个值
    9. 计算结果等于最大值
    10.计算结果等于最小值
    无效输入：
    1. 仅有一个值
    2. 计算结果超出范围
    3. 输入值有负数
     */
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = -1;
        int tmpResult;
        int limit = Integer.MIN_VALUE;
        int tmpLimit;

        while (leftIndex < rightIndex) {
            // 无效输入：输入值有负数
            if (height[leftIndex] < 0 || height[rightIndex] < 0) {
                return 0;
            }

            tmpLimit = limit / (rightIndex - leftIndex);
            if(tmpLimit > -(height[leftIndex] > height[rightIndex] ? height[leftIndex] : height[rightIndex])){
                //超范围
                return 0;
            }
            tmpResult = height[leftIndex] > height[rightIndex] ? height[rightIndex] * (rightIndex - leftIndex) : height[leftIndex] * (rightIndex - leftIndex);
            if (tmpResult > result) {
                result = tmpResult;
            }

            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }

        }

        return result;
    }
}
