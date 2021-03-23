package com.wmn.offer.a003_find_same_number;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-23
 */
public class FindSameNumber {
    /**
     * [2, 3, 1, 0, 2, 5, 3]
     * 让每一个下标值和实际值一一对应，一定会找到一个对应不上的
     */
    public int findRepeatNumber(int[] nums) {
        for (int i =0; i <nums.length ; i++) {
            while (nums[i] != i) {
                int index = nums[i];
                if (nums[index] != index) {
                    int temp = nums[i];
                    nums[index] = nums[i];
                    nums[i] = temp;
                } else {
                    return index;
                }
            }
        }
        return 0;
    }
}
