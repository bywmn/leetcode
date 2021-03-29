package com.wmn.leetcodetest.a010_reverse_number;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2020-03-29
 */
public class ReverseNum {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x %10 == 0 && x > 0) {
            return false;
        }
        int left = 0;
        while (left < x) {
            int completion = x % 10;
            left = left * 10 + completion;
            x /= 10;
        }
        // x长度为奇数 7位的话, left为4为，x为3位，比较left/10 和x
        // x长度为偶数,比较两个数是否相等
        return x == left || x == left / 10;
    }
}
