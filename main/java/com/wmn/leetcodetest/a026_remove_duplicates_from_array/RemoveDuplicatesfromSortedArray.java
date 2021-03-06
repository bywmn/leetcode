package com.wmn.leetcodetest.a026_remove_duplicates_from_array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-22
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            nums[left] = nums[right];
            while (right <nums.length && nums[right] == nums[left]) {
                right++;
            }
            left++;
        }
        return left;
    }
}
