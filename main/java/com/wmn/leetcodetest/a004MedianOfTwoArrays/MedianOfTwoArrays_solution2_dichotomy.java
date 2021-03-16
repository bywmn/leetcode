package com.wmn.leetcodetest.a004MedianOfTwoArrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 */
public class MedianOfTwoArrays_solution2_dichotomy {

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoArrays_solution2_dichotomy()
            .findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

    /**
     * 1,2,3,4,5 --> 5/2 +1
     * 1,2,3,4 --> 4/2 + (4/2+1)
     * 中位数，奇数时为第length/2 + 1个数，偶数时为length/2和length/2+1的平均数
     * 转换为求第K个最小的数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 数组为奇数个
        if ((length & 1) == 1) {
            return getKthMinValue(nums1, nums2, length / 2 + 1);
        }
        return (getKthMinValue(nums1, nums2, length / 2 + 1)
            + getKthMinValue(nums1, nums2, length / 2)) / 2.0d;
    }

    /**
     * 求解数组中的第k位最小值
     * 二分法，通过比较数组1和数组2中第k/2位数，排除掉k/2位小于等于中位数的
     * 边界条件：
     * 1.数组1中起始位置+2/k>length 则取length, 数组2同理
     * 2.数组1索引超过了长度，取数组2第k个值，数组2同理
     * 3.k=1,比较数组1、数组2当前的索引值
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k 第k位最小值
     * @return 第k位最小值
     */
    private int getKthMinValue(int[] nums1, int[] nums2, int k) {
        int start1 = 0;
        int start2 = 0;
        int length1= nums1.length;
        int length2 = nums2.length;
        while (k >= 1) {
            if (start1 == length1) {
                return nums2[k + start2 -1];
            }
            if (start2 == length2) {
                return nums1[k + start1 -1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int currentIndex1 = Math.min(start1 + k / 2 - 1, length1 - 1);
            int currentIndex2 = Math.min(start2 + k / 2 - 1, length2 - 1);
            if (nums1[currentIndex1] <= nums2[currentIndex2]) {
                k -= currentIndex1 - start1 + 1;
                start1 = currentIndex1 + 1;
            } else {
                k -= currentIndex2 - start2 + 1;
                start2 = currentIndex2 + 1;
            }
        }
        return 0;
    }
}
