package com.wmn.leetcodetest.a003_longest_substring;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author WMN
 * @since 2021-03-15
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 滑动窗口，两个指针：start，end
     * end指针不断后移，知道遇到和区间[start, end]内有相同的字符串时，记录当前长度 - 1比较最大值
     * start指针针移到重复位置的后一位，循环上面操作
     *
     * @param s 输入字符串
     * @return 最长不重复子串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength =0;
        char[] chars = s.toCharArray();
        for (int end = 0, start = 0; end < chars.length; end++) {
            char ch = chars[end];
            if (map.containsKey(ch)) {
                // 若区间内有相同字符，则记录长度，进行下一次循环
                int index = map.get(ch);
                if (index >= start) {
                    maxLength = Math.max(maxLength, end - start);
                    start = Math.max(start, index + 1);
                    map.put(ch, end);
                    continue;
                }
            }
            // 如果执行到了末尾
            if (end == chars.length -1) {
                return Math.max(maxLength, end -start + 1);
            }
            map.put(ch, end);
        }
        return maxLength;
    }

    /**
     * 与方法一的区别在于每一次符合条件的子串都进行一次最大值比较，直到条件不成立
     *
     * @param s 输入字符串
     * @return 最长不重复子串长度
     */
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength =0;
        char[] chars = s.toCharArray();
        for (int end = 0, start = 0; end < chars.length; end++) {
            char ch = chars[end];
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(ch, end);
        }
        return maxLength;
    }
}
