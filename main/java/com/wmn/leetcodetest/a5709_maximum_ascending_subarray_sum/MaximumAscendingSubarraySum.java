package com.wmn.leetcodetest.a5709_maximum_ascending_subarray_sum;

/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ascending-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-21
 */
public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        System.out.println(new MaximumAscendingSubarraySum().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int j = 1;
        int max = nums[0];
        int res = 0;
        while (i <= nums.length - 1 && j <= nums.length - 1) {
            System.out.println(max);
            if (nums[j] > nums[j - 1]) {
                max += nums[j];
                res = Math.max(res, max);
                j++;
            } else {
                res = Math.max(res, max);
                max = nums[j];
                i = j;
                j++;
            }
        }
        return res;
    }
}
