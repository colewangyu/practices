package LeetCode.Hard;

/**
 * Created by cole on 2016-11-06.
 */
public class _4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((n + m) % 2 == 1)
            return findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1);
        else
            return (findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1) +
                    findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2)) / 2.0;
    }

    private double findKthSortedArrays(int a[], int aStart, int aEnd,
                                       int b[], int bStart, int bEnd, int k) {
        if (a == null && b == null)
            throw new NullPointerException();
        if (aStart == aEnd && bStart == bEnd || k > (aEnd + bEnd - aStart - bStart))
            throw new IllegalArgumentException();

        // 一次计算中a数组中可能被抛弃的数的数量
        int aGap;
        // 一次计算中b数组中可能被抛弃的数的数量
        int bGap;
        while (true) {
            if (aEnd - aStart < bEnd - bStart) {
                int[] obj = a;
                a = b;
                b = obj;
                aStart = aStart ^ bStart;
                bStart = aStart ^ bStart;
                aStart = aStart ^ bStart;
                aEnd = a.length;
                bEnd = b.length;
            }

            if (bStart == bEnd)
                return a[aStart + k - 1];
            if (k == 1)
                return Math.min(a[aStart], b[bStart]);

            // 避免溢出
            bGap = Math.min(k / 2, bEnd - bStart);
            aGap = k - bGap;
            if (a[aStart + aGap - 1] > b[bStart + bGap - 1]) {
                // 抛弃比较小的b中的数
                bStart += bGap;
                k -= bGap;
            } else if (a[aStart + aGap - 1] < b[bStart + bGap - 1]) {
                aStart += aGap;
                k -= aGap;
            } else {
                return a[aStart + aGap - 1];
            }
        }
    }
//    /**
//     * 时间复杂度:O(n+m)
//     * @param nums1
//     * @param nums2
//     * @return
//     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int index1 = 0;
//        int index2 = 0;
//        List<Integer> integerList = new ArrayList<Integer>();
//        while (index1 < nums1.length && index2 < nums2.length) {
//            if (nums1[index1] < nums2[index2]) {
//                integerList.add(nums1[index1++]);
//            } else if (nums1[index1] > nums2[index2]) {
//                integerList.add(nums2[index2++]);
//            } else {
//                integerList.add(nums1[index1++]);
//                integerList.add(nums2[index2++]);
//            }
//        }
//        while (index1 < nums1.length) {
//            integerList.add(nums1[index1++]);
//        }
//        while (index2 < nums2.length) {
//            integerList.add(nums2[index2++]);
//        }
//        if (integerList.size() % 2 == 0) {
//            return (integerList.get(integerList.size() / 2) + integerList.get(integerList.size() / 2 - 1)) / 2.0;
//        } else if(integerList.size() > 1){
//            return integerList.get(integerList.size() / 2);
//        } else {
//            return (integerList.get(0));
//        }
//    }
}
