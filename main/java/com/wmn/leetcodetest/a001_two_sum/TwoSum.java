package com.wmn.leetcodetest.a001_two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-13
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }

    /**
     * 使用HashMap保存数组值和对应的索引，从第二个开始查询map是否已经有符合条件的索引，
     * 不符合则存入map，进行下一次循环
     * 符合则继续
     *
     * @param nums 整数数组
     * @param target 目标值
     * @return 符合条件的值下标
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target -nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
