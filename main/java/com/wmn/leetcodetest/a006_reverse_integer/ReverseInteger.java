package com.wmn.leetcodetest.a006_reverse_integer;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-18
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int complement = 0;
        while (x != 0) {
            if ((res > Integer.MAX_VALUE / 10) ||
                ((res == Integer.MAX_VALUE / 10) && complement > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if ((res < Integer.MIN_VALUE / 10) ||
                ((res == Integer.MIN_VALUE / 10) && complement < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            complement = x % 10;
            res = res * 10 + complement;
            x = x / 10;
        }
        return res;
    }
}
