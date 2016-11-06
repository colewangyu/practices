package LeetCode;

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

    private double findKthSortedArrays(int A[], int astart, int aend,
                                       int B[], int bstart, int bend, int k) {
        int m = aend - astart, n = bend - bstart;
        if (m < n) {
            return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);
        }
        if (n == 0)
            return A[astart + k - 1];
        if (k == 1)
            return Math.min(A[astart], B[bstart]);

        int pb = Math.min(k / 2, n), pa = k - pb;
        if (A[astart + pa - 1] > B[bstart + pb - 1])
            return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k - pb);
        else if (A[astart + pa - 1] < B[bstart + pb - 1])
            return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k - pa);
        else
            return A[astart + pa - 1];
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
