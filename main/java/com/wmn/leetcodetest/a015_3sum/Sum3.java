package com.wmn.leetcodetest.a015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-24
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return list;
        }
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int count = -nums[i];
            for (int j = i + 1;j <nums.length -1 ;j++) {
                if (j > i +1 && nums[j] == nums[j -1]) {
                    continue;
                }
                int end = nums.length -1;
                while (j <end && nums[j] + nums[end] > count) {
                    end--;
                }
                if (j == end) {
                    break;
                }
                if (nums[j] + nums[end] == count) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[end]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
