package com.wmn.leetcodetest.a5713_different_number_count;

import java.util.HashSet;
import java.util.Set;

import WeekTest.WeekTest;

/**
 *
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 *
 * @author WMN
 * @since 2021-03-28
 */
public class CountNumber {
    public static void main(String[] args) {
        System.out.println(new WeekTest().numDifferentIntegers("a123bc34d8ef34"));
    }

    public int numDifferentIntegers(String word) {
        Set<String> result = new HashSet<>();
        for (char ch = 'a' ; ch <= 'z';ch ++) {
            word = word.replaceAll(ch + "", " ");
        }
        String[] str = word.split("\\s+");
        for (String temp : str) {
            temp = temp.trim();
            if (temp.equals("")) {
                continue;
            }
            result.add(deleteZero(temp));
        }
        return result.size();
    }

    private String deleteZero(String str) {
        int index = str.length() - 1;
        for (int i = 0; i<str.length() - 1;i ++) {
            if (str.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        return str.substring(index);
    }
}
