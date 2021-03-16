package com.wmn.leetcodetest.a004MedianOfTwoArrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 */
public class MedianOfTwoArrays_solution1 {

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoArrays_solution1().findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));
    }

    /**
     * 1,2,3,4,5 --> 5/2 +1
     * 1,2,3,4 --> 4/2 + (4/2+1)
     * 中位数，奇数时为第length/2 + 1个数，偶数时为length/2和length/2+1的平均数
     * 定义两个指针left, right,
     * 当前索引为n,left指向第n - 1小的值，right指向第n小的值
     * 一直找到length/2 + 1个最值
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int start1 = 0;
        int start2 = 0;
        int index = (nums1.length + nums2.length) / 2 + 1;
        for (int i = 0; i < index; i++) {
            left = right; // left = 第i - 1小的值
            // 数组1已经全部统计完 或 数组1的值 >= 数组2的值
            if (start1 == nums1.length || (start2 < nums2.length && nums1[start1] >= nums2[start2])) {
                right = nums2[start2];
                start2++;
                continue;
            }
            right = nums1[start1];
            start1++;
        }
        // 若是奇数
        if (((nums1.length + nums2.length) & 1) == 1) {
            return right;
        }
        return (left + right) / 2.0d;
    }
}
