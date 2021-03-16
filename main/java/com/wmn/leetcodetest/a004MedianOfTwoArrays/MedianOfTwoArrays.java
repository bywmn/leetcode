package com.wmn.leetcodetest.a004MedianOfTwoArrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 */
public class MedianOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoArrays().findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));
    }

    /**
     * 1,2,3,4,5 --> 5/2 +1
     * 1,2,3,4 --> 4/2 + (4/2+1)
     * 中位数，奇数时为第length/2 + 1个数，偶数时为length/2和length/2+1的平均数
     * 从两个数组的第一位开始依次判断，找到目标数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            return getMedian(nums2, length2);
        }
        if (length2 == 0) {
            return getMedian(nums1, length1);
        }
        boolean isEvenNumber = ((length1 + length2) % 2 == 0); // 是否为偶数个数字
        int middle = (length1 + length2) / 2;
        // 奇数情况
        if (!isEvenNumber) {
            return getTargetValue(nums1, nums2, middle + 1);
        }
        return (getTargetValue(nums1, nums2, middle) + getTargetValue(nums1, nums2, middle + 1)) / 2.0d;
    }

    /**
     * 求一个数组中的中位数
     *
     * @param nums2 有序数组
     * @param length2 中位数的值
     * @return 中位数
     */
    private double getMedian(int[] nums2, int length2) {
        if (nums2.length % 2 == 0) {
            return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2.0d;
        } else {
            return nums2[length2 / 2];
        }
    }

    /**
     * 获取两个数组中第target小的值
     *
     * @param ans1 数组1
     * @param ans2 数组2
     * @param target 目标计数
     * @return 第target小的值
     */
    private int getTargetValue(int[] ans1, int[] ans2, int target) {
        int count = 0;
        int start1 = 0;
        int start2 = 0;
        int res = 0;
        while (count <= target) {
            // 已经找到count个最小值
            if (count == target) {
                return res;
            }
            if (start1 == ans1.length) {
                return ans2[target - start1 - 1];
            }
            if (start2 == ans2.length) {
                return ans1[target - start2 - 1];
            }
            if (ans1[start1] <= ans2[start2]) {
                res = ans1[start1];
                start1++;
            } else {
                res = ans2[start2];
                start2++;
            }
            count++;
        }
        return res;
    }
}
