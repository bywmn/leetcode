package com.wmn.leetcodetest.a004_longest_palindrome;

import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author WMN
 * @since 2021-03-17
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }

    /**
     * 动态规划思路，dp[i][j] = dp[i+1][j-1]
     *
     * @param s 字符串
     * @return 子串
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int start = 0;
        int max = 1;
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                    continue;
                }
                // 解决"cbbd"场景，否则的话dp[2][3] = dp[3][2]时[3,2]未初始化
                // 即当i+1>=j—1时，此时虽然dp[j-1][j+?]未初始化，但一定为true
                if(j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1]; // 因为运行到此处j>i,因此不会越界
                }
                if (dp[i][j] && (j - i + 1 > max)) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }
}